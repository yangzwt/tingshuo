package com.tingshuo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysPost;

/**
 * 类文件描述:
 * 岗位信息业务接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 13:13
 **/
public interface ISysPostService extends IService<SysPost> {
    /**
     * 岗位信息查询列表
     * @param pageNo
     * @param pageSize
     * @param sysPost
     * @return
     */
    PageResult list(Integer pageNo, Integer pageSize, SysPost sysPost);
}
