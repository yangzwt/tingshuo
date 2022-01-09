package com.tingshuo.job.utils.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类文件描述:
 * Quartz的job在项目重启时，job都失效了，把每次启动的job都存放在数据库，然后项目启动时监听器读取数据库的job，然后添加job
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月09日 14:33
 **/
//@Component
//@Order(value = 1)
public class QuartzJobListener implements CommandLineRunner {
    @Autowired
    private QuartzScheduler quartzScheduler;

    /**
     * 初始启动quartz
     * @param
     */
    @Override
    public void run(String... args) throws Exception {
        try {
            // quartzScheduler.startJob();

            // 此处就不写获取数据库了，模拟一个集合遍历的数据
            List<Map<String,Object>> listMap=new ArrayList<>();
            Map<String, Object> map1= new HashMap<>(16);
            map1.put("jobClass","com.tingshuo.job.task.TsTask");
            map1.put("jobName","job1");
            map1.put("jobGroupName","job1");
            map1.put("jobTime","0/5 * * * * ? ");
            listMap.add(map1);
            for (Map<String, Object> map : listMap) {
                try {
                    quartzScheduler.addJob((String)map.get("jobName"),(String)map.get("jobGroupName"), (String)map.get("jobName"),(String)map.get("jobGroupName"),(String)map1.get("jobClass"),(String)map.get("jobTime"),new HashMap<>(16));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("任务已经启动...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
