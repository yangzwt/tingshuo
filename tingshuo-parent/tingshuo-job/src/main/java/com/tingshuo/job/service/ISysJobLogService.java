package com.tingshuo.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.job.entity.SysJobLog;

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
    public void addJobLog(SysJobLog jobLog);
}
