package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.common.core.result.R;
import com.tingshuo.system.entity.SysUser;
import com.tingshuo.system.mapper.SysUserMapper;
import com.tingshuo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Auth yangZ
 * @Date 2021-08-15 20:54
 */
@Service("ISysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUserName(String userName) {
        return sysUserMapper.selectUserByUserName(userName);
    }

    @Override
    public PageResult selectUserList(Integer pageNo, Integer pageSize,SysUser sysUser) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysUser> sysUsers = sysUserMapper.selectUserList(sysUser);
        PageInfo pageInfo = new PageInfo();
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysUsers).getTotal());//总数
        pageResult.setContent(sysUsers);
        return pageResult;
    }


}
