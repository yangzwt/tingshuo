package com.tingshuo.system.vo;

import java.io.Serializable;

/**
 * 类文件描述:
 * 返回前端用户基本信息
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:08
 **/
public class LoginUserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    private String token;
    /**
     * 用户名id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
