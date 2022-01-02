package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingshuo.system.entity.SysMenu;
import com.tingshuo.system.entity.SysUser;
import com.tingshuo.system.mapper.SysMenuMapper;
import com.tingshuo.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月02日 10:25
 **/
@Service("ISysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 用户菜单查询
     * @param userId
     * @param sysMenu
     * @return
     */
    @Override
    public List<SysMenu> selectMenuList(Long userId, SysMenu sysMenu) {
        List<SysMenu> sysMenus=null;
        if (SysUser.isAdmin(userId)){
            //特殊处理系统管理员查询全部菜单
            sysMenus = sysMenuMapper.selectMenuList(sysMenu);
        }else {
            //普通用户查询部分菜单
            sysMenu.getParams().put("userId",userId);
            sysMenus = sysMenuMapper.selectMenuListByUserId(sysMenu);
        }
        return sysMenus;
    }
}
