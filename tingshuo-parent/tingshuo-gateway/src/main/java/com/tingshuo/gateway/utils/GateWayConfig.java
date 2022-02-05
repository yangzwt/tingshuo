package com.tingshuo.gateway.utils;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 类文件描述:
 * 通过javaAPI方式配置路由
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月04日 12:23
 **/
//@Configuration
public class GateWayConfig {
    /**
     * 通过配置注解bean来定义RouteLocator
     * 转发到http://www.baidu.com
     * @param routeLocatorBuilder
     * @return
     */

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder.routes()
                .route("tingshuo-test",r->r.path("/tingshuo-test/**").uri("http://www.baidu.com")).build();
    }
}
