package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.system.entity.SysMenu;

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
}
