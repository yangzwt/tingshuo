package com.tingshuo.job.task;

import com.tingshuo.common.core.utils.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;

/**
 * 类文件描述:
 * 定时任务入口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月08日 16:44
 **/
//@Component("TsTask")
public class TsTask implements Job {
    /**
     * 无参方法执行定时任务
     */
    public void tSNoParams(){
        System.out.println("执行无参方法");
    }
    /**
     * 一个参数的定时任务
     * @param params
     */
    public void tSParams(String params){
        System.out.println("执行有参方法：" + params);
    }
    /**
     * 多参定时任务
     * @param s
     * @param b
     * @param l
     * @param d
     * @param i
     */
    public  void tSMultipleParams(String s, Boolean b, Long l, Double d, Integer i){
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String jobName = context.getJobDetail().getKey().toString();
        System.out.println(jobName + "任务开始执行：" + dateformat.format(System.currentTimeMillis()));
        // TODO 业务job1.job1
        System.out.println(jobName + "任务执行完成：" + dateformat.format(System.currentTimeMillis()));

    }
}
