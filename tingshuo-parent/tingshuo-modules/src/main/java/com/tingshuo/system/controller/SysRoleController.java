package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysRoleApi;
import com.tingshuo.system.entity.SysRole;
import com.tingshuo.system.param.SysRolePo;
import com.tingshuo.system.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月01日 21:41
 **/
@RestController
public class SysRoleController implements SysRoleApi {
    @Autowired
    private ISysRoleService sysRoleService;
    /**
     * 用户角色列表查询
     * @param pageNo
     * @param pageSize
     * @param sysRolePo
     * @return
     */

    @Override
    public PageResult selectUserRolePageList(Integer pageNo, Integer pageSize, SysRolePo sysRolePo) {
        SysRole  sysRole = new SysRole();
        BeanUtils.copyProperties(sysRolePo,sysRole);//对象拷贝
        return sysRoleService.selectRolePageList(pageNo,pageSize,sysRole);
    }
}
