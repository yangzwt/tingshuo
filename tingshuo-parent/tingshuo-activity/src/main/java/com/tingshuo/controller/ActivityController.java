package com.tingshuo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 测试openfegin进行远程调用测试类
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月02日 10:55
 **/
@RestController
public class ActivityController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/getString")
    public String ActivityOpenFeign(){
        return "欢迎使用openfeign-调用工作流系统-端口"+port;
    }
}

