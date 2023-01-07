package com.tingshuo.system.api;

import com.tingshuo.common.core.result.ResponseResult;
import com.tingshuo.system.vo.LoginUserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类文件描述:
 * 用户登录、用户退出、用户注册：相关操作
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 20:51
 **/

public interface LoginApi {
    /**
     * 用户登录相关操作
     * @param loginUserVo
     * @return
     */
    @PostMapping("/login")
    ResponseResult<?> login(@RequestBody LoginUserVO loginUserVo);

    @PostMapping("/api/login")
    ResponseResult<?> loginApi(@RequestBody LoginUserVO loginUserVo);
}
