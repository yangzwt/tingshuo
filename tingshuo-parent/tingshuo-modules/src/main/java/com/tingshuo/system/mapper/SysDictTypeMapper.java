package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysDictType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 * 字典相关数据传输
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 17:27
 **/
@Mapper
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {
    /**
     * 字典查询集合
     * @param sysDictType
     * @return
     */
    List <SysDictType> selectDictTypeList(SysDictType sysDictType);
}
