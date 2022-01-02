package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysLoginInfo;

/**
 * 类文件描述:
 * 系统登录日志业务接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:47
 **/
public interface ISysLoginInfoService extends IService<SysLoginInfo> {
    /**
     * 系统登录日志 分页查询
     * @param pageNo
     * @param pageSize
     * @param sysLoginInfo
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysLoginInfo sysLoginInfo);
}
