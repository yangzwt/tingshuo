package com.tingshuo.erueka;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 听说微服务
 * eureka注册中心
 * @EnableEurekaServer 开启注册中心服务端
 */

@SpringBootApplication
@EnableEurekaServer
public class TingshuoEruekaApplication {
 private static final Logger logger= LoggerFactory.getLogger(TingshuoEruekaApplication.class);
    public static void main(String[] args) {
        logger.info("听说微服务注册中心-服务端-开启启动");
        SpringApplication.run(TingshuoEruekaApplication.class, args);
        logger.info("听说微服务注册中心启动-服务端-启动成功");
    }

}
