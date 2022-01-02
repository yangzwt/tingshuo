package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysDept;
import com.tingshuo.system.mapper.SysDeptMapper;
import com.tingshuo.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Auth yangZ
 * @Date 2021-08-15 20:54
 */
@Service("ISysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;


    /**
     * 机构信息查询列表
     * @param pageNo
     * @param pageSize
     * @param sysDept
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysDept sysDept) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysDept> sysDepts = sysDeptMapper.selectDeptList(sysDept);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysDepts).getTotal());//总数
        pageResult.setContent(sysDepts);
        return pageResult;
    }
}
