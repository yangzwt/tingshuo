package com.tingshuo.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.job.entity.SysJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类文件描述:
 * 定时任务数据传输
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月06日 21:37
 **/
@Mapper
public interface SysJobMapper extends BaseMapper<SysJob> {
}
