package com.tingshuo.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.job.entity.SysJobLog;

import java.util.List;

/**
 * 类文件描述:
 * 定时任务记录日志
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月07日 21:09
 **/
public interface ISysJobLogService extends IService<SysJobLog> {
    /**
     * 新增任务日志
     *
     * @param jobLog 调度日志信息
     */
   void addJobLog(SysJobLog jobLog);

    /**
     * 获取quartz调度器日志的计划任务
     *
     * @param jobLog 调度日志信息
     * @return 调度任务日志集合
     */
    List<SysJobLog> selectJobLogList(SysJobLog jobLog);

    /**
     * 通过调度任务日志ID查询调度信息
     *
     * @param jobLogId 调度任务日志ID
     * @return 调度任务日志对象信息
     */
    SysJobLog selectJobLogById(Long jobLogId);


    /**
     * 批量删除调度日志信息
     *
     * @param logIds 需要删除的日志ID
     * @return 结果
     */
    int deleteJobLogByIds(Long[] logIds);

    /**
     * 删除任务日志
     *
     * @param jobId 调度日志ID
     * @return 结果
     */
    int deleteJobLogById(Long jobId);

    /**
     * 清空任务日志
     */
    void cleanJobLog();
}
