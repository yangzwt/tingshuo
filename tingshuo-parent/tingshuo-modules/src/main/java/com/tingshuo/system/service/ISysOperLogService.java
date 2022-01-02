package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysOperLog;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:12
 **/
public interface ISysOperLogService extends IService<SysOperLog> {
    /**
     *
     * @param pageNo
     * @param pageSize
     * @param sysOperLog
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysOperLog sysOperLog);
}
