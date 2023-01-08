package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.common.core.result.ResponseResult;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.system.api.SysUserApi;
import com.tingshuo.system.entity.LoginUser;
import com.tingshuo.system.entity.SysUserPo;
import com.tingshuo.system.service.ISysUserService;
import com.tingshuo.system.vo.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult<LoginUser> info(@PathVariable("username") String username)
    {
        SysUserPo sysUser = sysUserService.selectUserByUserName(username);
        if (StringUtils.isNull(sysUser))
        {
            return ResponseResult.fail("用户名或密码错误");
        }
        // 角色集合
        //Set<String> roles = permissionService.getRolePermission(sysUser.getUserId());
        // 权限集合
        //Set<String> permissions = permissionService.getMenuPermission(sysUser.getUserId());
        //LoginUser sysUserVo = new LoginUser();
        //sysUserVo.setSysUser(sysUser);
        //sysUserVo.setRoles(roles);
        //sysUserVo.setPermissions(permissions);
        //return R.ok(sysUserVo);
        return null;
    }
    @GetMapping("/selectUserPageList")
    public PageResult selectPageList(@RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                                     @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                                     SysUserVO sysUserVO){
        SysUserPo sysUserPo = new SysUserPo();
        BeanUtils.copyProperties(sysUserVO,sysUserPo);//对象拷贝
        return  sysUserService.selectUserList(pageNo,pageSize,sysUserPo);
    }

    /**
     * 用户分页查询
     * @param pageNo
     * @param pageSize
     * @param sysUserVO
     * @return
     */
    @Override
    public PageResult selectUserPageList(SysUserVO sysUserVO,Integer pageNo, Integer pageSize) {
        SysUserPo sysUserPo = new SysUserPo();
        BeanUtils.copyProperties(sysUserVO,sysUserPo);//对象拷贝
        return sysUserService.selectUserPageList(pageNo,pageSize,sysUserPo);
    }
}
