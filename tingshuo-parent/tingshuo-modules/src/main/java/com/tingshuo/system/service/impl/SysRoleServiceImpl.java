package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysRole;
import com.tingshuo.system.mapper.SysRoleMapper;
import com.tingshuo.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月01日 21:46
 **/
@Service("ISysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService{
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 角色列表分页查询
     * @param pageNo
     * @param pageSize
     * @param sysRole
     * @return
     */
    @Override
    public PageResult selectRolePageList(Integer pageNo, Integer pageSize, SysRole sysRole) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysRole> sysRoles = sysRoleMapper.selectRolePageList(sysRole);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysRoles).getTotal());//总数
        pageResult.setContent(sysRoles);
        return pageResult;
    }
}
