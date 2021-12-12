package com.tingshuo.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingshuo.common.core.result.R;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.common.core.utils.page.QueryGenerator;
import com.tingshuo.system.entity.LoginUser;
import com.tingshuo.system.entity.SysUser;
import com.tingshuo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SysUserController
 * 基本用户信息
 * @Auth yangZ
 * @Date 2021-08-15 21:01
 */
@RestController
@RequestMapping("/user")
public class SysUserController  {
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

    public R<IPage<SysUser>> selectPageList(SysUser user ,
                                            @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                                            @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                                            HttpServletRequest req){
        R<IPage<SysUser>> result = new R<IPage<SysUser>>();

        return  result;
    }
}