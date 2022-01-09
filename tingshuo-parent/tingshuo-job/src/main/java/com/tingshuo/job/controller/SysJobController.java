package com.tingshuo.job.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.job.api.SysJobApi;
import com.tingshuo.job.entity.SysJob;
import com.tingshuo.job.param.SysJobPo;
import com.tingshuo.job.service.ISysJobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月08日 16:51
 **/
@RestController
public class SysJobController implements SysJobApi {
    @Autowired
    private ISysJobService sysJobService;
    @Override
    public PageResult selectSysJobPageList(Integer pageNo, Integer pageSize, SysJobPo sysJobPo) {
        SysJob sysJob = new SysJob();
        BeanUtils.copyProperties(sysJobPo,sysJob);//对象拷贝
        return sysJobService.selectSysJobList(pageNo,pageSize,sysJob);
    }

    @Override
    public PageResult run(SysJobPo sysJobPo) throws Exception {
        SysJob sysJob = new SysJob();
        BeanUtils.copyProperties(sysJobPo,sysJob);//对象拷贝
        sysJobService.run(sysJob);

        //sysJobService.execute();
        return null;
    }
}
