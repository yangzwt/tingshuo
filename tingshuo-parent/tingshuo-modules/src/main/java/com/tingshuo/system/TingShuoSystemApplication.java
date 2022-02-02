package com.tingshuo.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 听说微服务，基础业务项目入口模块
 *@EnableEurekaClient 将当前项目注册到注册中心
 * @EnableFeignClients 声明使用 feign进行服务调用
 * user：yangz
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TingShuoSystemApplication {
    /**
     * 实例化ribbon使用的RestTemplate
     * 注人spring管理
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate rebbionRestTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {

        SpringApplication.run(TingShuoSystemApplication.class,args);
    }
}
