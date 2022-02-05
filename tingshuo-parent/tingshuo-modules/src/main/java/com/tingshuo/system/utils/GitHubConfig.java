package com.tingshuo.system.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * 类文件描述:
 * 注册bean获取文件
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月05日 21:25
 **/
//@Component
public class GitHubConfig {
    @Value("${server.port}")
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
