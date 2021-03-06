package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.common.core.result.R;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.system.api.SysUserApi;
import com.tingshuo.system.entity.LoginUser;
import com.tingshuo.system.entity.SysUser;
import com.tingshuo.system.param.SysUserPo;
import com.tingshuo.system.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SysUserController
 * 基本用户信息
 * @Auth yangZ
 * @Date 2021-08-15 21:01
 */
@RestController
public class SysUserController implements SysUserApi {
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
    @GetMapping("/selectUserPageList")
    public PageResult selectPageList(@RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                                     @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                                     SysUser sysUser){
        return  sysUserService.selectUserList(pageNo,pageSize,sysUser);
    }

    /**
     * 用户分页查询
     * @param pageNo
     * @param pageSize
     * @param sysUserPo
     * @return
     */
    @Override
    public PageResult selectUserPageList(Integer pageNo, Integer pageSize, SysUserPo sysUserPo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserPo,sysUser);//对象拷贝
        return sysUserService.selectUserPageList(pageNo,pageSize,sysUser);
    }
}
