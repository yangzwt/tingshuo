package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysOperLogApi;
import com.tingshuo.system.entity.SysOperLog;
import com.tingshuo.system.vo.SysOperLogVO;
import com.tingshuo.system.service.ISysOperLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 21:10
 **/
@RestController
public class SysOperLogController implements SysOperLogApi {
    @Autowired
    private ISysOperLogService sysOperLogService;
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysOperLogVO sysOperLogPo) {
        SysOperLog sysOperLog= new SysOperLog();
        BeanUtils.copyProperties(sysOperLogPo, sysOperLog);//对象拷贝
        return sysOperLogService.list(pageNo,pageSize,sysOperLog);
    }
}
