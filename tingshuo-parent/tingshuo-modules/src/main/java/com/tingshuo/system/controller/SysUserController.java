package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.R;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.system.entity.LoginUser;
import com.tingshuo.system.entity.SysUser;
import com.tingshuo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysUserController
 * 基本用户信息
 * @Auth yangZ
 * @Date 2021-08-15 21:01
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private  ISysUserService sysUserService;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @GetMapping("/info/{username}")
    public R<LoginUser> info(@PathVariable("username") String username)
    {
        SysUser sysUser = sysUserService.selectUserByUserName(username);
        if (StringUtils.isNull(sysUser))
        {
            return R.fail("用户名或密码错误");
        }
        // 角色集合
        //Set<String> roles = permissionService.getRolePermission(sysUser.getUserId());
        // 权限集合
        //Set<String> permissions = permissionService.getMenuPermission(sysUser.getUserId());
        LoginUser sysUserVo = new LoginUser();
        sysUserVo.setSysUser(sysUser);
        //sysUserVo.setRoles(roles);
        //sysUserVo.setPermissions(permissions);
        return R.ok(sysUserVo);
    }

}
