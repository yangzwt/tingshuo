package com.tingshuo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.system.entity.SysLoginInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:53
 **/
@Mapper
public interface SysLoginInfoMapper  extends BaseMapper<SysLoginInfo> {

    List<SysLoginInfo> selectLoginInfoList(SysLoginInfo sysLoginInfo);
}
