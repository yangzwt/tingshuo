package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.ResponseResult;
import com.tingshuo.system.api.LoginApi;
import com.tingshuo.system.entity.LoginUser;
import com.tingshuo.system.entity.SysUserPo;
import com.tingshuo.system.service.ILoginService;
import com.tingshuo.system.vo.LoginUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2023年01月07日 14:59
 **/
@RestController
public class LoginController implements LoginApi {
    @Autowired
    private ILoginService iLoginService;
    @Override
    public ResponseResult<?> login(LoginUserVO loginUserVo) {
        LoginUser loginUser=new LoginUser();
        BeanUtils.copyProperties(loginUserVo,loginUser);//对象拷贝
        SysUserPo login = iLoginService.login(loginUserVo.getUserId(), loginUserVo.getPassword());
        if (login!=null){
           return ResponseResult.ok(login);
        }else {
            return ResponseResult.fail("用户不不存在");
        }
    }

    @Override
    public ResponseResult<?> loginApi(LoginUserVO loginUserVo) {
        return null;
    }
}
