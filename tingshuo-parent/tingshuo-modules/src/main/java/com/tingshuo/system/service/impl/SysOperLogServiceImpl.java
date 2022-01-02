package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysOperLog;
import com.tingshuo.system.mapper.SysOperLogMapper;
import com.tingshuo.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:16
 **/
@Service("ISysOperLogService")
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {
    @Autowired
    private SysOperLogMapper sysOperLogMapper;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysOperLog sysOperLog) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysOperLog> sysOperLogs = sysOperLogMapper.selectOperLogList(sysOperLog);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysOperLogs).getTotal());//总数
        pageResult.setContent(sysOperLogs);
        return pageResult;
    }
}
