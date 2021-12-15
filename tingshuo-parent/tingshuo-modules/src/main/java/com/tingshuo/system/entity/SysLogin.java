package com.tingshuo.system.entity;

import com.tingshuo.common.core.web.entity.BaseEntity;

/**
 * 类文件描述:
 * 用户登录基本信息
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 20:56
 **/
public class SysLogin extends BaseEntity {
    private static final long serialVersionUID = 1L;
    //用户姓名
    private String username;
    // 用户密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
