package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUserName(String userName) {
        return sysUserMapper.selectUserByUserName(userName);
    }

    @Override
    public R<SysUser> selectUserList(Integer pageNo, Integer pageSize) {
        IPage<SysUser> userIPage=new Page<>(pageNo,pageSize);
        IPage<SysUser> iPage=sysUserMapper.selectPage(userIPage,null);
        List<SysUser> records = iPage.getRecords();

        long total = iPage.getTotal();
        R<SysUser> request = new R<SysUser>();
        //request.setData();
        return request;
    }


}
