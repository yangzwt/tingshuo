package com.tingshuo.job.param;

import java.util.Date;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月08日 16:56
 **/
public class SysJobPo {
    /**
     * 任务id
     */
    private Long jobId;
    /**
     * job_name
     * 任务名称
     */
    private String jobName;

    /**
     * job_group
     * 任务组名
     */
    private String jobGroup;

    /**
     * invoke_target
     * 调用目标字符串
     */
    private String invokeTarget;

    /**
     * cron_expression
     * cron执行表达式
     */
    private String cronExpression;

    /**
     * misfire_policy
     * 计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     */
    private String misfirePolicy;

    /**
     * concurrent
     * 是否并发执行（0允许 1禁止）
     */
    private String concurrent;

    /**
     * status
     * 状态（0正常 1暂停）
     */
    private String status;

    /**
     * create_by
     * 创建者
     */
    private String createBy;

    /**
     * create_time
     * 创建时间
     */
    private Date createTime;

    /**
     * update_by
     * 更新者
     */
    private String updateBy;

    /**
     * update_time
     * 更新时间
     */
    private Date updateTime;

    /**
     * remark
     * 备注信息
     */
    private String remark;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getInvokeTarget() {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getMisfirePolicy() {
        return misfirePolicy;
    }

    public void setMisfirePolicy(String misfirePolicy) {
        this.misfirePolicy = misfirePolicy;
    }

    public String getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
