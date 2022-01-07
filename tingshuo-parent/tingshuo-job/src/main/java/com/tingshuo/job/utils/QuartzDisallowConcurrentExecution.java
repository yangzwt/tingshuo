package com.tingshuo.job.utils;

import com.tingshuo.job.entity.SysJob;
import org.quartz.JobExecutionContext;

/**
 * 类文件描述:
 * 定时任务处理（禁止并发执行）
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月07日 21:27
 **/
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
