package com.tingshuo.system.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 类文件描述:
 * ConfigurationProperties 获取文件内容
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月05日 21:27
 **/
@Component
@ConfigurationProperties(prefix = "server")
public class GitAutoRefreshConfig {

    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
