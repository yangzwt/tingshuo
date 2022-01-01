package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysRole;

/**
 * 类文件描述:
 * 用户角色相关业务接口
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月01日 21:44
 **/
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 用户角色列表查询
     * @param pageNo
     * @param pageSize
     * @param sysRole
     * @return
     */
    PageResult selectRolePageList(Integer pageNo, Integer pageSize, SysRole sysRole);
}
