package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.system.entity.SysUserPo;

/**
 * 类文件描述:
 *  用户登录、用户退出、用户注册
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:02
 **/
public interface ILoginService extends IService<SysUserPo> {
    /**
     * 用户登录相关
     * @param userId
     * @param password
     * @return
     */
    SysUserPo login(String userId, String password);
}
