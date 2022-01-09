package com.tingshuo.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.exception.job.TaskException;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.job.entity.SysJob;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

/**
 * 类文件描述:
 * 定时任务 业务接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月06日 21:38
 **/
public interface ISysJobService extends IService<SysJob> {
    /**
     * 通过调度任务ID查询调度信息
     * @param jobId
     * @return
     */
    SysJob selectSysJobById(Long jobId);
    /**
     * 获取quartz调度器的计划任务
     * @param sysJob
     * @return
     */
    PageResult selectSysJobList(Integer pageNo, Integer pageSize, SysJob sysJob);
    /**
     * 删除定时任务
     * @param sysJob
     * @return
     */
    int deleteSysJob(SysJob sysJob) throws SchedulerException;

    /**
     * 批量删除定时任务
     * @param jobIds
     */
    void deleteSysJobList(Long [] jobIds) throws SchedulerException;
    /**
     * 运行任务
     * @param sysJob
     * @throws SchedulerException
     */
    void run(SysJob sysJob) throws Exception;
    /**
     * 新增定时任务
     * @param sysJob
     * @return
     */
    int insertSysJob(SysJob sysJob) throws SchedulerException, TaskException;
    /**
     * 暂停任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    int pauseJob(SysJob sysJob) throws SchedulerException;

    /**
     * 恢复任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    int resumeJob(SysJob sysJob) throws SchedulerException;

    /**
     * 任务调度状态修改
     * @param sysJob
     * @return
     * @throws SchedulerException
     */
    int changeStatus(SysJob sysJob) throws SchedulerException;

    /**
     * 更新任务
     * @param sysJob
     * @return
     * @throws SchedulerException
     * @throws TaskException
     */
    int updateJob(SysJob sysJob) throws SchedulerException,TaskException;

    /**
     * 校验cron表达式是否有效
     * @param cronExpression 表达式
     * @return 结果
     */
    boolean checkCronExpressionIsValid(String cronExpression);

    void execute() throws JobExecutionException;
}
