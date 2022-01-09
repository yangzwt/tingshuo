package com.tingshuo.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.exception.job.TaskException;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.job.constants.ScheduleConstants;
import com.tingshuo.job.entity.SysJob;
import com.tingshuo.job.mapper.SysJobMapper;
import com.tingshuo.job.service.ISysJobService;
import com.tingshuo.job.task.TsTask;
import com.tingshuo.job.utils.CronUtils;
import com.tingshuo.job.utils.ScheduleUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * 类文件描述:
 * 定时任务 业务实现类
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月06日 21:40
 **/
@Service("ISysJobService")
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService,Job {
    @Autowired
    private  SysJobMapper sysJobMapper;
    @Autowired
    private Scheduler scheduler;

    /**
     * 校验cron表达式是否有效
     * @param cronExpression 表达式
     * @return
     */
    @Override
    public boolean checkCronExpressionIsValid(String cronExpression) {
        return CronUtils.isValid(cronExpression);
    }

    @Override
    public void execute() throws JobExecutionException {

        System.out.println((String.format("welcome %s! Jeecg-Boot 带参数定时任务 SampleParamJob !   时间:" + new Date(), "hehhe")));
    }


    /**
     * 项目启动时，初始化定时器 主要是防止手动修改数据库导致未同步到定时任务处理（注：不能手动修改数据库ID和任务组名，否则会导致脏数据）
     */
    @PostConstruct
    public void init() throws SchedulerException, TaskException
    {
        scheduler.clear();
        List<SysJob> sysJobs = sysJobMapper.selectJobAll();
        for (SysJob sysJob : sysJobs) {
            ScheduleUtils.createScheduleJob(scheduler,sysJob);
        }
    }
    /**
     * 获取quartz调度器的计划任务列表
     * @param sysJob
     * @return
     */
    @Override
    public PageResult selectSysJobList(Integer pageNo, Integer pageSize,SysJob sysJob) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysJob> sysJobs = sysJobMapper.selectJobList(sysJob);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysJobs).getTotal());//总数
        pageResult.setContent(sysJobs);
        return pageResult;
    }
    /**
     * 通过调度任务ID查询调度信息
     * @param jobId
     * @return
     */
    @Override
    public SysJob selectSysJobById(Long jobId) {
        return sysJobMapper.selectSysJobById(jobId);
    }
    /**
     * 创建定时任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     * @throws TaskException
     */
    @Override
    public int insertSysJob(SysJob sysJob) throws SchedulerException, TaskException {
        sysJob.setStatus("0");//
        int insert = sysJobMapper.insertJob(sysJob);
        if (insert>0){
            ScheduleUtils.createScheduleJob(scheduler,sysJob);
        }
        return insert;
    }

    /**
     * 暂停任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    @Override
    public int pauseJob(SysJob sysJob) throws SchedulerException {
        sysJob.setStatus("1");//1暂停任务
        int i = sysJobMapper.updateSysJob(sysJob);
        if (i>0){
            scheduler.pauseJob(ScheduleUtils.getJobKey(sysJob.getJobId(),sysJob.getJobGroup()));
        }
        return i;
    }
    /**
     * 恢复任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    @Override
    public int resumeJob(SysJob sysJob) throws SchedulerException {
        sysJob.setStatus("3");//3 恢复任务
        int i = sysJobMapper.updateSysJob(sysJob);
        if (i>0){
            scheduler.resumeJob(ScheduleUtils.getJobKey(sysJob.getJobId(),sysJob.getJobGroup()));
        }
        return i;
    }

    /**
     * 任务调度状态修改
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    @Override
    public int changeStatus(SysJob sysJob) throws SchedulerException {
        String status = sysJob.getStatus();
        int row=0;
        if ("1".equals(status)){
            row=resumeJob(sysJob);
        }else {
            row=pauseJob(sysJob);
        }
        return row;
    }

    /**
     * 更新任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     * @throws TaskException
     */
    @Override
    public int updateJob(SysJob sysJob) throws SchedulerException,TaskException {
        SysJob job = selectSysJobById(sysJob.getJobId());
        int i = sysJobMapper.updateSysJob(job);
        if (i>0){
            updateSchedulerJob(sysJob,sysJob.getJobGroup());
        }
        return 0;
    }
    /**
     * 更新任务
     *
     * @param job 任务对象
     * @param jobGroup 任务组名
     */
    public void updateSchedulerJob(SysJob job, String jobGroup) throws SchedulerException, TaskException
    {
        Long jobId = job.getJobId();
        // 判断是否存在
        JobKey jobKey = ScheduleUtils.getJobKey(jobId,job.getJobGroup());
        if (scheduler.checkExists(jobKey)){
            // 防止创建时存在数据问题 先移除，然后在执行创建操作
            scheduler.deleteJob(jobKey);
        }
        ScheduleUtils.createScheduleJob(scheduler, job);
    }

    /**
     * 删除定时任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    @Override
    public int deleteSysJob(SysJob sysJob) throws SchedulerException{
        int i = sysJobMapper.deleteSysJobId(sysJob.getJobId());
        if (i>0){
            scheduler.deleteJob(ScheduleUtils.getJobKey(sysJob.getJobId(),sysJob.getJobGroup()));
        }
        return i;
    }

    /**
     * 批量删除定时任务
     * @param jobIds
     * @throws SchedulerException
     */
    @Override
    public void deleteSysJobList(Long[] jobIds) throws SchedulerException {
        for (Long jobId : jobIds) {
            SysJob sysJob = sysJobMapper.selectSysJobById(jobId);
            deleteSysJob(sysJob);
        }
    }

    /**
     * 立即运行任务
     * @param sysJob
     * @throws SchedulerException
     */
    @Override
    public void run(SysJob sysJob) throws Exception {
        SysJob job = selectSysJobById(sysJob.getJobId());
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(ScheduleConstants.TASK_PROPERTIES,job);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
        //jobDataMap.put(job.getInvokeTarget(),job);
        //scheduler.triggerJob(ScheduleUtils.getJobKey(sysJob.getJobId(),sysJob.getJobGroup()),jobDataMap);
        JobDetail build = JobBuilder.newJob(TsTask.class).withIdentity("job1", "DEFAULT").build();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "DEFAULT").withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(build, cronTrigger);
        //scheduler.start();
        if (!scheduler.isShutdown()){
            scheduler.start();
        }

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }

    private static Job getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (Job) class1.newInstance();
    }
}
