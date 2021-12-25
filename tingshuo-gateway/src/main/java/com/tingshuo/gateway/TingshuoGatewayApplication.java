package com.tingshuo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注释：
 * 听说微服务
 * 服务网关
 * @Auto YZ
 * @Date 2021年12月25日20:48:37
 */
@SpringBootApplication
@EnableEurekaClient
public class TingshuoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TingshuoGatewayApplication.class, args);
    }

}
