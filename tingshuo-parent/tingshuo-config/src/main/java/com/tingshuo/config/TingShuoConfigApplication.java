package com.tingshuo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类文件描述:
 * 听说微服务的配置中心
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月05日 13:30
 **/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
@EnableConfigServer
public class TingShuoConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(TingShuoConfigApplication.class,args);
    }
}
