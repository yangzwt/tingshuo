package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysNotice;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:11
 **/

public interface ISysNoticeService extends IService<SysNotice> {
    /**
     *
     * @param pageNo
     * @param pageSize
     * @param sysNotice
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysNotice sysNotice);
}
