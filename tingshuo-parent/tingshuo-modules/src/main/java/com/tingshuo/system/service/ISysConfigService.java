package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysConfig;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:16
 **/
public interface ISysConfigService extends IService<SysConfig> {
    /**
     * 系统设置业务实现接口
     * @param pageNo
     * @param pageSize
     * @param sysConfig
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysConfig sysConfig);
}
