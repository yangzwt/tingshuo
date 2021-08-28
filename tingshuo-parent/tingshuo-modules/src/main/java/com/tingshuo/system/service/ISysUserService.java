package com.tingshuo.system.service;

import com.tingshuo.system.entity.SysUser;

/**
 * @ClassName ISysUserService
 * 用户 业务层
 * @Auth yangZ
 * @Date 2020-08-15 20:53
 */
public interface ISysUserService {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return SysUser
     */
    SysUser selectUserByUserName(String userName);
}
