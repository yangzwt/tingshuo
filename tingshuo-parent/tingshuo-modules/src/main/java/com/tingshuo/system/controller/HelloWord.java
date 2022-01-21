package com.tingshuo.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWord {
    @Autowired
    RestTemplate restTemplate;
//	在application.yml（配置文件）中直接修改，spring.application.name: (不带下划线的服务名，强制要求)，eureka.instance.instance-id:(服务标识，建议与服务名相同，但是带端口号)
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String HelloWord(){
        return "你好世界。欢迎来到我的听说项目世界-system";
    }
    @RequestMapping(value = "/helloTest",method = RequestMethod.GET)
    public String helloTest(){
       return restTemplate.getForObject("http://tingshuo-activity/hello",String.class);
    }
}
