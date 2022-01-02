package com.tingshuo.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.entity.SysNotice;
import com.tingshuo.system.mapper.SysNoticeMapper;
import com.tingshuo.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:15
 **/
@Service("ISysNoticeService")
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {
    @Autowired
    private SysNoticeMapper sysNoticeMapper;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysNotice sysNotice) {
        PageHelper.startPage(pageNo,pageSize);
        List<SysNotice> sysNotices = sysNoticeMapper.selectNoticeList(sysNotice);
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(new PageInfo(sysNotices).getTotal());//总数
        pageResult.setContent(sysNotices);
        return pageResult;
    }
}
