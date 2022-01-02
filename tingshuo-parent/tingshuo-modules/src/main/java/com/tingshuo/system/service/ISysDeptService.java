package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysDept;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 12:38
 **/
public interface ISysDeptService extends IService<SysDept> {
    /**
     * 机构查询分页
     * @param pageNo
     * @param pageSize
     * @param sysDept
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysDept sysDept);
}
