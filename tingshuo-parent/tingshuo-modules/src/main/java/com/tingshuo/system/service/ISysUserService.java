package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysUser;
import com.tingshuo.system.vo.LoginUserVo;


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
     * @param pageNo
     * @param pageSize
     * @param sysUser
     * @return
     */
    PageResult selectUserList(Integer pageNo, Integer pageSize,SysUser sysUser);

    /**
     * 用户查询分页列表接口
     * @param pageNo
     * @param pageSize
     * @param sysUser
     * @return
     */
    PageResult selectUserPageList(Integer pageNo, Integer pageSize,SysUser sysUser);

    /**
     * 根据用户名
     * 查看单个用户基本信息
     * @param username
     * @param password
     * @return
     */
    LoginUserVo getUserInfo(String username,String password);

}
