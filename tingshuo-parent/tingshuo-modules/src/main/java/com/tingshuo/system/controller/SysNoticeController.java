package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysNoticeApi;
import com.tingshuo.system.entity.SysNotice;
import com.tingshuo.system.vo.SysNoticeVO;
import com.tingshuo.system.service.ISysNoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:08
 **/
@RestController
public class SysNoticeController implements SysNoticeApi {
    @Autowired
    private ISysNoticeService sysNoticeService;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysNoticeVO sysNoticePo) {
        SysNotice sysNotice =new SysNotice();
        BeanUtils.copyProperties(sysNoticePo, sysNotice);//对象拷贝
        return sysNoticeService.list(pageNo,pageSize,sysNotice);
    }
}
