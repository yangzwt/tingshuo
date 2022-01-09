package com.tingshuo.job.utils.quartz;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 类文件描述:
 * 任务调度器 Scheduler
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月09日 14:23
 **/
//@Configuration
public class QuartzConfig {
    private JobFactory jobFactory;

    public QuartzConfig(JobFactory jobFactory){
        this.jobFactory = jobFactory;
    }

    /**
     * 配置SchedulerFactoryBean
     * 将一个方法产生为Bean并交给Spring容器管理
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        // Spring提供SchedulerFactoryBean为Scheduler提供配置信息,并被Spring容器管理其生命周期
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 设置自定义Job Factory，用于Spring管理Job bean
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() {
        //return schedulerFactoryBean().getScheduler();
        return null;
    }
}
