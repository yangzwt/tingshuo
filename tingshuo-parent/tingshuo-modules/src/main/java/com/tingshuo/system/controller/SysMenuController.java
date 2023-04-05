package com.tingshuo.system.controller;

import com.tingshuo.common.core.web.entity.AjaxResult;
import com.tingshuo.system.api.SysMenuApi;
import com.tingshuo.system.entity.SysMenu;
import com.tingshuo.system.vo.SysMenuVO;
import com.tingshuo.system.service.ISysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类文件描述:
 * 菜单相关业务
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月02日 10:22
 **/
@RestController
public class SysMenuController implements SysMenuApi {
    @Autowired
    private ISysMenuService sysMenuService;
    @Override
    public AjaxResult list(SysMenuVO sysMenuPo) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuPo,sysMenu);//对象拷贝
        String userId="1";
        return AjaxResult.success(sysMenuService.selectMenuList(userId,sysMenu));
    }

    @Override
    public AjaxResult treeselect(SysMenuVO sysMenuVO) {
        String userId="1";
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuVO,sysMenu);//对象拷贝
        List<SysMenu> menus = sysMenuService.selectMenuList(userId,sysMenu);
        return AjaxResult.success(sysMenuService.buildMenuTreeSelect(menus));
    }
}
