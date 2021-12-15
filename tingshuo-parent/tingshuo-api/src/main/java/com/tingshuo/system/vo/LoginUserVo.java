package com.tingshuo.system.vo;

import java.io.Serializable;

/**
 * 类文件描述:
 * 返回前端用户基本信息
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:08
 **/
public class LoginUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户名id
     */
    private Long userid;

    /**
     * 用户名
     */
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
