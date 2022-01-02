package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 * 菜单相关数据传输
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月02日 10:28
 **/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu>{
    /**
     * 查询系统菜单列表
     *
     * @param sysMenu 菜单信息
     * @return 菜单列表
     */
    List<SysMenu> selectMenuList(SysMenu sysMenu);

    /**
     * 根据用户查询系统菜单列表
     *
     * @param sysMenu 菜单信息
     * @return 菜单列表
     */
    List<SysMenu> selectMenuListByUserId(SysMenu sysMenu);
}
