package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysLoginInfoApi;
import com.tingshuo.system.entity.SysLoginInfo;
import com.tingshuo.system.param.SysLoginInfoPo;
import com.tingshuo.system.service.ISysLoginInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:44
 **/
@RestController
public class SysLoginInfoController implements SysLoginInfoApi {
    @Autowired
    private ISysLoginInfoService sysLoginInfoService;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysLoginInfoPo sysLoginInfoPo) {
        SysLoginInfo sysLoginInfo = new SysLoginInfo();
        BeanUtils.copyProperties(sysLoginInfoPo, sysLoginInfo);//对象拷贝
        return sysLoginInfoService.list(pageNo,pageSize,sysLoginInfo);
    }
}
