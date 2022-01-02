package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:17
 **/
@Mapper
public interface SysOperLogMapper  extends BaseMapper<SysOperLog> {

    List<SysOperLog> selectOperLogList(SysOperLog sysOperLog);
}
