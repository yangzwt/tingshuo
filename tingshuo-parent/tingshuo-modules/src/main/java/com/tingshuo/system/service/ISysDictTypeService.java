package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysDictType;

/**
 * 类文件描述:
 * 字典相关业务接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 17:21
 **/
public interface ISysDictTypeService extends IService <SysDictType> {
    /**
     * 字典分页查询
     * @param pageNo
     * @param pageSize
     * @param sysDictType
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysDictType sysDictType);
}
