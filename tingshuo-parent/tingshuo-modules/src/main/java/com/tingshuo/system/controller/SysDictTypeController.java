package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysDictTypeApi;
import com.tingshuo.system.entity.SysDictType;
import com.tingshuo.system.vo.SysDictTypeVO;
import com.tingshuo.system.service.ISysDictTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 字典相关业务实现
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 17:17
 **/
@RestController
public class SysDictTypeController implements SysDictTypeApi {
    @Autowired
    private ISysDictTypeService sysDictTypeService;
    /**
     * 字典分页查询
     * @param pageNo
     * @param pageSize
     * @param sysDictTypePo
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysDictTypeVO sysDictTypePo) {
        SysDictType sysDictType =new SysDictType();
        BeanUtils.copyProperties(sysDictTypePo,sysDictType);//对象拷贝
        return sysDictTypeService.list(pageNo,pageSize,sysDictType);
    }
}
