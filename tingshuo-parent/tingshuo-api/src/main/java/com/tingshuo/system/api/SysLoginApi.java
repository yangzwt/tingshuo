package com.tingshuo.system.api;

import com.tingshuo.common.core.result.R;
import com.tingshuo.system.param.SysLoginPo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 用户登录、用户退出、用户注册：相关操作
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 20:51
 **/
@RestController
public interface SysLoginApi {
    /**
     * 用户登录相关操作
     * @param sysLoginPo
     * @return
     */
    @PostMapping("/login")
    R<?> login(@RequestBody SysLoginPo sysLoginPo);
}
