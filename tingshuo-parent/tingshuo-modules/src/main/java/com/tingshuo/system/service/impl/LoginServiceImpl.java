package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingshuo.common.core.exception.BaseException;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.system.entity.SysUserPo;
import com.tingshuo.system.mapper.SysLoginMapper;
import com.tingshuo.system.service.ILoginService;
import com.tingshuo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类文件描述:
 * 用户登录、用户退出、用户注册相关业务操作
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:11
 **/
@Service("ISysLoginService")
public class LoginServiceImpl extends ServiceImpl<SysLoginMapper, SysUserPo> implements ILoginService {

    @Autowired
    private ISysUserService sysUserService;
    /**
     * 用户登录相关业务操作
      * @param userId
     * @param password
     * @return
     */
    @Override
    public SysUserPo login(String userId, String password) {
        if (StringUtils.isEmpty(userId)){
            throw  new BaseException("用户编号不能为空");
        }
        return sysUserService.getUserInfo(userId, password);
    }
}
