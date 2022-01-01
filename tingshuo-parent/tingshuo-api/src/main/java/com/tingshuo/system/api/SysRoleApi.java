package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.param.SysRolePo;
import org.springframework.web.bind.annotation.*;

/**
 * 类文件描述:
 * 用户角色接口
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月01日 21:36
 **/

@RequestMapping("/role")
public interface SysRoleApi {

    @PostMapping("/list")
    PageResult selectUserRolePageList(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                                  @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                                  SysRolePo sysRolePo);
}
