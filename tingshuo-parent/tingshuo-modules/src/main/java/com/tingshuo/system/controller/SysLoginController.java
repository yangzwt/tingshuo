package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.R;
import com.tingshuo.system.api.SysLoginApi;
import com.tingshuo.system.entity.SysLogin;
import com.tingshuo.system.param.SysLoginPo;
import com.tingshuo.system.service.ISysLoginService;
import com.tingshuo.system.vo.LoginUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:00
 **/
public class SysLoginController implements SysLoginApi {
    @Autowired
    private ISysLoginService sysLoginService;

    @Override
    public R<?> login(SysLoginPo sysLoginPo) {
        SysLogin sysLogin = new SysLogin();
        BeanUtils.copyProperties(sysLoginPo,new SysLogin());
        LoginUserVo login = sysLoginService.login(sysLogin.getUsername(), sysLogin.getPassword());
        return R.ok(login);
    }
}
