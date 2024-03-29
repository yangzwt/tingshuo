package com.tingshuo.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 12:30
 **/
public class SysDeptVO {
        private static final long serialVersionUID = 1L;

        /** 部门ID */
        private Long deptId;

        /** 父部门ID */
        private Long parentId;

        /** 祖级列表 */
        private String ancestors;

        /** 部门名称 */
        private String deptName;

        /** 显示顺序 */
        private String orderNum;

        /** 负责人 */
        private String leader;

        /** 联系电话 */
        private String phone;

        /** 邮箱 */
        private String email;

        /** 部门状态:0正常,1停用 */
        private String status;

        /** 删除标志（0代表存在 2代表删除） */
        private String delFlag;

        /** 父部门名称 */
        private String parentName;

        /** 子部门 */
        private List<SysDeptVO> children = new ArrayList<SysDeptVO>();

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
        public Long getDeptId()
        {
            return deptId;
        }

        public void setDeptId(Long deptId)
        {
            this.deptId = deptId;
        }

        public Long getParentId()
        {
            return parentId;
        }

        public void setParentId(Long parentId)
        {
            this.parentId = parentId;
        }

        public String getAncestors()
        {
            return ancestors;
        }

        public void setAncestors(String ancestors)
        {
            this.ancestors = ancestors;
        }

        @NotBlank(message = "部门名称不能为空")
        @Size(min = 0, max = 30, message = "部门名称长度不能超过30个字符")
        public String getDeptName()
        {
            return deptName;
        }

        public void setDeptName(String deptName)
        {
            this.deptName = deptName;
        }

        @NotBlank(message = "显示顺序不能为空")
        public String getOrderNum()
        {
            return orderNum;
        }

        public void setOrderNum(String orderNum)
        {
            this.orderNum = orderNum;
        }

        public String getLeader()
        {
            return leader;
        }

        public void setLeader(String leader)
        {
            this.leader = leader;
        }

        @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
        public String getPhone()
        {
            return phone;
        }

        public void setPhone(String phone)
        {
            this.phone = phone;
        }

        @Email(message = "邮箱格式不正确")
        @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public String getDelFlag()
        {
            return delFlag;
        }

        public void setDelFlag(String delFlag)
        {
            this.delFlag = delFlag;
        }

        public String getParentName()
        {
            return parentName;
        }

        public void setParentName(String parentName)
        {
            this.parentName = parentName;
        }

        public List<SysDeptVO> getChildren()
        {
            return children;
        }

        public void setChildren(List<SysDeptVO> children)
        {
            this.children = children;
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

    @Override
        public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("deptId", getDeptId())
                .append("parentId", getParentId())
                .append("ancestors", getAncestors())
                .append("deptName", getDeptName())
                .append("orderNum", getOrderNum())
                .append("leader", getLeader())
                .append("phone", getPhone())
                .append("email", getEmail())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
        }
}
