package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysUserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface SysUserMapper  extends BaseMapper<SysUserPo> {

    /**
     * 查询用户列表
     * @param sysUser
     * @return
     */
    List<SysUserPo> selectUserList(SysUserPo sysUserPo);
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return SysUser
     */
    SysUserPo selectUserByUserName(String userName);

    /**
     * 查看用户基本信息
     * @param username
     * @return
     */
    SysUserPo getUserInfo(@Param("userId") String userId);
}
