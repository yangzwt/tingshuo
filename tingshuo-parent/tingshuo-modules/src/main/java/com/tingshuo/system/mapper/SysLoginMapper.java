package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysUserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类描述
 *  用户登录基础dao
 * 制作者 yangz
 * 2021-12-15
 *
 */
@Mapper
public interface SysLoginMapper extends BaseMapper<SysUserPo> {

}
