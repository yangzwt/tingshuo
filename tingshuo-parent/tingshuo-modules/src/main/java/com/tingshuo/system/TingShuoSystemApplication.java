package com.tingshuo.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 听说微服务，基础业务项目入口模块
 *
 * user：yangz
 */
@SpringBootApplication
public class TingShuoSystemApplication {
    public static void main(String[] args) {

        SpringApplication.run(TingShuoSystemApplication.class,args);
    }
}
