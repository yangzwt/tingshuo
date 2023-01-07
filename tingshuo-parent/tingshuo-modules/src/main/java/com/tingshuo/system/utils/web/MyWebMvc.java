package com.tingshuo.system.utils.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 类文件描述:
 * 跨域解决
 * @author yangz
 * @version 1.0.0
 * @date 2022年10月29日 21:53
 **/
@SuppressWarnings("deprecation")
@Configuration
public class MyWebMvc implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new TingShuoInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .addPathPatterns("/api/test/**");
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
