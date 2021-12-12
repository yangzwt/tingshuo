package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.R;
import com.tingshuo.system.entity.SysUser;

import java.util.List;

/**
 * @ClassName ISysUserService
 * 用户 业务层
 * @Auth yangZ
 * @Date 2020-08-15 20:53
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return SysUser
     */
    SysUser selectUserByUserName(String userName);

    /**
     * 分页查询用户信息
     * @param sysUser
     * @return
     */
    R<SysUser> selectUserList(Integer pageNo, Integer pageSize);
}