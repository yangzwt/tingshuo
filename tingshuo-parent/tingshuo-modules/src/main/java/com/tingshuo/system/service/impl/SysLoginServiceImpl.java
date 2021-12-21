package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingshuo.common.core.exception.BaseException;
import com.tingshuo.common.core.result.R;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.system.entity.SysLogin;
import com.tingshuo.system.mapper.SysLoginMapper;
import com.tingshuo.system.service.ISysLoginService;
import com.tingshuo.system.service.ISysUserService;
import com.tingshuo.system.vo.LoginUserVo;
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
public class SysLoginServiceImpl extends ServiceImpl<SysLoginMapper,SysLogin> implements ISysLoginService {

    @Autowired
    private ISysUserService sysUserService;
    /**
     * 用户登录相关业务操作
      * @param username
     * @param password
     * @return
     */
    @Override
    public LoginUserVo login(String username, String password) {
        if (StringUtils.isEmpty(username)){
            throw  new BaseException("用户名不能为空");
        }
        LoginUserVo userInfo = sysUserService.getUserInfo(username, password);
        return userInfo;
    }
}
