package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.system.entity.SysMenu;
import com.tingshuo.system.entity.TreeSelect;

import java.util.List;

/**
 * 类文件描述:
 * 菜单相关业务接口
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月02日 10:24
 **/

public interface ISysMenuService extends IService <SysMenu> {
    /**
     * 查询用户菜单
     * @param userId
     * @param sysMenu
     * @return
     */
    List<SysMenu> selectMenuList(String userId,SysMenu sysMenu);
    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);
    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);
}
