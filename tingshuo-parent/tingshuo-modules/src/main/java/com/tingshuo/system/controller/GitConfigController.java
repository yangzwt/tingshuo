package com.tingshuo.system.controller;

import com.tingshuo.system.utils.GitAutoRefreshConfig;
import com.tingshuo.system.utils.GitHubConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 获取配置github文件
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月05日 21:26
 **/
@RestController
public class GitConfigController {
    @Autowired
    private GitHubConfig gitHubConfig;
    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;
    @GetMapping("/show")
    public Object show(){
       return gitHubConfig;
    }
    @GetMapping("/showConfig")
    public Object showConfig(){
        return gitAutoRefreshConfig;
    }
}
