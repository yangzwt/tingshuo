package com.tingshuo.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingshuo.job.entity.SysJobLog;
import com.tingshuo.job.mapper.SysJobLogMapper;
import com.tingshuo.job.service.ISysJobLogService;
import org.springframework.stereotype.Service;

/**
 * 类文件描述:
 * 定时任务记录日志业务实现类
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月07日 21:16
 **/
@Service("ISysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements ISysJobLogService {
    @Override
    public void addJobLog(SysJobLog jobLog) {

    }
}
