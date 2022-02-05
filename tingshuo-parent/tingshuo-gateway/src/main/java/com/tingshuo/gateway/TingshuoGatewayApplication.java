package com.tingshuo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * 类文件描述:
 * 听说微服务
 * 服务网关
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月05日 10:21
 **/
@SpringBootApplication
@EnableEurekaClient
public class TingshuoGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(TingshuoGatewayApplication.class, args);
    }
    @Bean
    public KeyResolver ipKeyResolver(){
        System.out.println("执行了限流错误");
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
