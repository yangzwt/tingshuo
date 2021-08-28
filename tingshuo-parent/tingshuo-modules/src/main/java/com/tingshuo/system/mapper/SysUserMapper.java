package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类描述
 *  用户基础dao
 * 制作者 yangz
 *
 * 2021-08-15
 *
 */
@Mapper
public interface SysUserMapper  extends BaseMapper<SysUser> {

    /**
     * 查询用户列表
     * @param sysUser
     * @return
     */
    List<SysUser> selectUserList(SysUser sysUser);
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return SysUser
     */
    SysUser selectUserByUserName(String userName);
}
