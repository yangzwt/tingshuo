package com.tingshuo.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.exception.job.TaskException;
import com.tingshuo.job.entity.SysJob;
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
     * 新增定时任务
     * @param sysJob
     * @return
     */
    int insertSysJob(SysJob sysJob) throws SchedulerException, TaskException;

    /**
     * 通过调度任务ID查询调度信息
     * @param jobId
     * @return
     */
    SysJob selectSysJobById(Long jobId);

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
}
