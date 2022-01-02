package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysDictType;
import com.tingshuo.system.mapper.SysDictTypeMapper;
import com.tingshuo.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 17:23
 **/
@Service("/ISysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {
    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;
    /**
     * 字典分页查询
     * @param pageNo
     * @param pageSize
     * @param sysDictType
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysDictType sysDictType) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysDictType> selectDictTypeList = sysDictTypeMapper.selectDictTypeList(sysDictType);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(selectDictTypeList).getTotal());//总数
        pageResult.setContent(selectDictTypeList);
        return pageResult;
    }
}
