package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:18
 **/
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    /**
     * 系统设置数据传输
     * @param sysConfig
     * @return
     */
    List<SysConfig> selectConfigList(SysConfig sysConfig);
}
