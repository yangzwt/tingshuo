package com.tingshuo.system;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 听说微服务，基础业务项目入口模块
 * @EnableEurekaClient 将当前项目注册到注册中心
 * @EnableFeignClients 声明使用 feign进行服务调用
 * @EnableHystrixDashboard 开启服务监控
 * @EnableCircuitBreaker 监控Servlet
 * @EnableTurbine 开启Turbine聚合监控数据
 * @EnableApolloConfig 开启Apollo 配置中心
 * user：yangz
 * @author :yangz
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
@EnableApolloConfig
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

    /**
     * 配置servlet boot2.0版本需要配置Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet  =new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
    public static void main(String[] args) {
        SpringApplication.run(TingShuoSystemApplication.class,args);
    }
}
