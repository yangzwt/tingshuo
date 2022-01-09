package com.tingshuo.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.job.entity.SysJobLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 * 定时任务 记录日志
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月07日 21:17
 **/
@Mapper
public interface SysJobLogMapper extends BaseMapper<SysJobLog> {
    /**
     * 查看日志列表
     * @param jobLog
     * @return
     */
    List<SysJobLog> selectJobLogList(SysJobLog jobLog);
    /**
     * 清空任务日志
     */
    void cleanJobLog();
}
