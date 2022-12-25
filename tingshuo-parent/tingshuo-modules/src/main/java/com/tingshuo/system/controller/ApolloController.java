package com.tingshuo.system.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 测试从Apollo 环境信息
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月06日 16:04
 **/
@RestController
public class ApolloController {
    @Value("${test}")
    private String name;
    @GetMapping("/testApollo")
    public String Apollo(){
        System.out.println("测试Apollo获取参数");
        return name;
    }
}
