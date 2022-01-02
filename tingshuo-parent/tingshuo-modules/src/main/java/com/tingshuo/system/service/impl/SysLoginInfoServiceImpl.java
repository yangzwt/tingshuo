package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysLoginInfo;
import com.tingshuo.system.mapper.SysLoginInfoMapper;
import com.tingshuo.system.service.ISysLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:52
 **/
@Service("ISysLoginInfoService")
public class SysLoginInfoServiceImpl extends ServiceImpl<SysLoginInfoMapper, SysLoginInfo> implements ISysLoginInfoService {
    @Autowired
    private SysLoginInfoMapper sysLoginInfoMapper;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysLoginInfo sysLoginInfo) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysLoginInfo> sysLoginInfos = sysLoginInfoMapper.selectLoginInfoList(sysLoginInfo);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysLoginInfos).getTotal());//总数
        pageResult.setContent(sysLoginInfos);
        return pageResult;
    }
}
