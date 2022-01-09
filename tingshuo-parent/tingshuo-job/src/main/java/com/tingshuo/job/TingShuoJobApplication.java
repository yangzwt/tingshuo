package com.tingshuo.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月08日 16:49
 **/
@SpringBootApplication
@EnableEurekaClient
public class TingShuoJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(TingShuoJobApplication.class,args);
    }
}
