package com.tingshuo.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingshuo.job.entity.SysJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类文件描述:
 * 定时任务数据传输
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月06日 21:37
 **/
@Mapper
public interface SysJobMapper extends BaseMapper<SysJob> {
    /**
     * 定时任务查询列表
     * @param sysJob
     * @return
     */
    List<SysJob> selectJobList(SysJob sysJob);

    /**
     * 查询所有调度任务
     * @return
     */
    List<SysJob>  selectJobAll();
    /**
     * 新增调度任务信息
     *
     * @param job 调度任务信息
     * @return 结果
     */
    int insertJob(SysJob job);

    /**
     *
     * @param jobId
     * @return
     */
    SysJob selectSysJobById(Long jobId);

    int updateSysJob(SysJob sysJob);
    /**
     * 通过调度ID删除调度任务信息
     *
     * @param jobId 调度ID
     * @return 结果
     */
    int deleteSysJobId(Long jobId);
    /**
     * 批量删除调度任务信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteJobByIds(Long[] ids);
}
