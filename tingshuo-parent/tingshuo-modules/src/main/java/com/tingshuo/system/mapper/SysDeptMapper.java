package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类描述
 *  用户基础dao
 * 制作者 yangz
 *
 * 2021-08-15
 *
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 查询机构列表
     * @param sysDept
     * @return
     */
    List<SysDept> selectDeptList(SysDept sysDept);

}
