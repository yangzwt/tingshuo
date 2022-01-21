package com.tingshuo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String HelloWord(){
        return "你好世界。欢迎来到我的听说项目世界-activity";
    }
}
