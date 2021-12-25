package com.tingshuo.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 听说微服务，基础业务项目入口模块
 *@EnableEurekaClient 将当前项目注册到注册中心
 * user：yangz
 */
@SpringBootApplication
@EnableEurekaClient
public class TingShuoSystemApplication {
    public static void main(String[] args) {

        SpringApplication.run(TingShuoSystemApplication.class,args);
    }
}
