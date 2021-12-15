package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.system.entity.SysLogin;
import com.tingshuo.system.vo.LoginUserVo;

/**
 * 类文件描述:
 *  用户登录、用户退出、用户注册
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:02
 **/
public interface ISysLoginService extends IService<SysLogin> {
    /**
     * 用户登录相关
     * @param username
     * @param password
     * @return
     */
    public LoginUserVo login(String username,String password);
}
