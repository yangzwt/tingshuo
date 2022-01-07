package com.tingshuo.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingshuo.common.core.exception.job.TaskException;
import com.tingshuo.job.entity.SysJob;
import com.tingshuo.job.mapper.SysJobMapper;
import com.tingshuo.job.service.ISysJobService;
import com.tingshuo.job.utils.JobUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 类文件描述:
 * 定时任务 业务实现类
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月06日 21:40
 **/
@Service("ISysJobService")
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {
    @Autowired
    private  SysJobMapper sysJobMapper;
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private JobUtils jobUtils;

    /**
     * 项目启动时，初始化定时器 主要是防止手动修改数据库导致未同步到定时任务处理（注：不能手动修改数据库ID和任务组名，否则会导致脏数据）
     */
    @PostConstruct
    public void init() throws SchedulerException, TaskException
    {
        scheduler.clear();
        List<SysJob> sysJobs = sysJobMapper.selectList(null);
        for (SysJob sysJob : sysJobs) {
            jobUtils.createSysJob(scheduler,sysJob);
        }
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
        int insert = sysJobMapper.insert(sysJob);
        if (insert>0){
            jobUtils.createSysJob(scheduler,sysJob);
        }
        return insert;
    }
    /**
     * 通过调度任务ID查询调度信息
     * @param jobId
     * @return
     */
    @Override
    public SysJob selectSysJobById(Long jobId) {
        return sysJobMapper.selectById(jobId);
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
        int i = sysJobMapper.updateById(sysJob);
        if (i>0){
            scheduler.pauseJob(jobUtils.getJobKey(sysJob));
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
        int i = sysJobMapper.updateById(sysJob);
        if (i>0){
            scheduler.resumeJob(jobUtils.getJobKey(sysJob));
        }
        return i;
    }
}
