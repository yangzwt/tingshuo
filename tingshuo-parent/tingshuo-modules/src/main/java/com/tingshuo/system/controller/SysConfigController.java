package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysConfigApi;
import com.tingshuo.system.entity.SysConfig;
import com.tingshuo.system.param.SysConfigPo;
import com.tingshuo.system.service.ISysConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:15
 **/
@RestController
public class SysConfigController implements SysConfigApi {
    @Autowired
    private ISysConfigService sysConfigService;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysConfigPo sysConfigPo) {
        SysConfig sysConfig= new SysConfig();
        BeanUtils.copyProperties(sysConfigPo,sysConfig);//对象拷贝
        return sysConfigService.list(pageNo,pageSize,sysConfig);
    }
}
