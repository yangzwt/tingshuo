package com.tingshuo.job.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.job.param.SysJobPo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 定时任务接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月08日 16:52
 **/
@RequestMapping("/sysjob")
public interface SysJobApi {
    @PostMapping("/list")
    PageResult selectSysJobPageList(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                                    @RequestParam(name="pageSize",defaultValue = "15")Integer pageSize,
                                    SysJobPo sysJobPo);
    @PostMapping("/run")
    PageResult run(@RequestBody SysJobPo sysJobPo) throws Exception;
}
