package com.tingshuo.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingshuo.job.entity.SysJobLog;
import com.tingshuo.job.mapper.SysJobLogMapper;
import com.tingshuo.job.service.ISysJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 * 定时任务记录日志业务实现类
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月07日 21:16
 **/
@Service("ISysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements ISysJobLogService {
    @Autowired
    private SysJobLogMapper sysJobLogMapper;
    @Override
    public void addJobLog(SysJobLog jobLog) {
        sysJobLogMapper.insert(jobLog);
    }

    /**
     * 获取quartz调度器日志的计划任务
     * @param jobLog 调度日志信息
     * @return
     */
    @Override
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog) {

        return sysJobLogMapper.selectJobLogList(jobLog);
    }

    /**
     * 通过调度任务日志ID查询调度信息
     * @param jobLogId 调度任务日志ID
     * @return
     */
    @Override
    public SysJobLog selectJobLogById(Long jobLogId) {
        return sysJobLogMapper.selectById(jobLogId);
    }

    /**
     * 批量删除调度日志信息
     * @param logIds 需要删除的日志ID
     * @return
     */
    @Override
    public int deleteJobLogByIds(Long[] logIds) {
        int i=0;
        for (Long logId : logIds) {
            i = sysJobLogMapper.deleteById(logId);
        }
        return i;
    }

    /**
     * 删除任务日志
     * @param jobId 调度日志ID
     * @return
     */
    @Override
    public int deleteJobLogById(Long jobId) {

        return sysJobLogMapper.deleteById(jobId);
    }

    /**
     * 清空任务日志
     */
    @Override
    public void cleanJobLog() {
        sysJobLogMapper.cleanJobLog();
    }
}
