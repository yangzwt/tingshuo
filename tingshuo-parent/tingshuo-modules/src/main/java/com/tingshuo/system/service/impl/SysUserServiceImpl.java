package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysUserPo;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserPo> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserPo selectUserByUserName(String userName) {
        return sysUserMapper.selectUserByUserName(userName);
    }

    @Override
    public PageResult selectUserList(Integer pageNo, Integer pageSize,SysUserPo SysUserPo) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysUserPo> sysUsers = sysUserMapper.selectUserList(SysUserPo);
        PageInfo pageInfo = new PageInfo();
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysUsers).getTotal());//总数
        pageResult.setContent(sysUsers);
        return pageResult;
    }

    /**
     * 用户分页查询业务逻辑
     * @param pageNo
     * @param pageSize
     * @param sysUser
     * @return
     */
    @Override
    public PageResult selectUserPageList(Integer pageNo, Integer pageSize, SysUserPo SysUserPo) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysUserPo> sysUsers = sysUserMapper.selectUserList(SysUserPo);
        PageInfo pageInfo = new PageInfo();
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysUsers).getTotal());//总数
        pageResult.setContent(sysUsers);
        return pageResult;
    }

    @Override
    public SysUserPo getUserInfo(String userId, String password) {
        return sysUserMapper.getUserInfo(userId);
    }


}
