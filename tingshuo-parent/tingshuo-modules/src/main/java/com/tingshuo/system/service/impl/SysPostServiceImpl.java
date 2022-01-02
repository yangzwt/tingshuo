package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysPost;
import com.tingshuo.system.mapper.SysPostMapper;
import com.tingshuo.system.service.ISysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 13:21
 **/
@Service("ISysPostService")
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {
    @Autowired
    private SysPostMapper sysPostMapper;
    /**
     * 岗位信息查询业务实现类
     * @param pageNo
     * @param pageSize
     * @param sysPost
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysPost sysPost) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysPost> sysPostList = sysPostMapper.selectPostList(sysPost);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysPostList).getTotal());//总数
        pageResult.setContent(sysPostList);
        return pageResult;
    }
}
