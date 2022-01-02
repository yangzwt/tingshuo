package com.tingshuo.system.controller;

import com.tingshuo.common.core.web.entity.AjaxResult;
import com.tingshuo.system.api.SysMenuApi;
import com.tingshuo.system.entity.SysMenu;
import com.tingshuo.system.param.SysMenuPo;
import com.tingshuo.system.service.ISysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
    public AjaxResult list(SysMenuPo sysMenuPo) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuPo,sysMenu);//对象拷贝
        Long userId=1L;
        return AjaxResult.success(sysMenuService.selectMenuList(userId,sysMenu));
    }
}
