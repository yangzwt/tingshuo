package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysConfig;
import com.tingshuo.system.mapper.SysConfigMapper;
import com.tingshuo.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:17
 **/
@Service("ISysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {
    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 系统设置分页业务实现类
     * @param pageNo
     * @param pageSize
     * @param sysConfig
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysConfig sysConfig) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysConfig> sysConfigs = sysConfigMapper.selectConfigList(sysConfig);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysConfigs).getTotal());//总数
        pageResult.setContent(sysConfigs);
        return pageResult;
    }
}
