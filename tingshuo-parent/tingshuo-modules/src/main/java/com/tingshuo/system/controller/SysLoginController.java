package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.R;
import com.tingshuo.common.core.utils.StringUtils;
import com.tingshuo.system.api.SysLoginApi;
import com.tingshuo.system.entity.SysLogin;
import com.tingshuo.system.param.SysLoginPo;
import com.tingshuo.system.service.ISysLoginService;
import com.tingshuo.system.vo.LoginUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 21:00
 **/
@RestController
public class SysLoginController implements SysLoginApi {
    @Autowired
    private ISysLoginService sysLoginService;

    /**
     * 用户登录方法
     * 2021-12-21
     * @param sysLoginPo
     * @return
     */
    @Override
    public R<?> login(SysLoginPo sysLoginPo) {
        SysLogin sysLogin = new SysLogin();
        BeanUtils.copyProperties(sysLoginPo,sysLogin);
        LoginUserVo login = sysLoginService.login(sysLogin.getUsername(), sysLogin.getPassword());
        if (StringUtils.isNull(login)){
          return  R.fail("登录用户不存在，请重新输入");
        }
        return R.ok(login,"用户登录成功");
    }
}
