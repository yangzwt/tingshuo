package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName SysUserRole
 * 角色列表
 * @Auth yangz
 * @Date 2022-01-01
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 角色列表
     * @param sysRole
     * @return
     */
    List<SysRole> selectRolePageList(SysRole sysRole);
}
