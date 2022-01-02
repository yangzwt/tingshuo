package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.param.SysConfigPo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 系统设置api接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:03
 **/
@RequestMapping("/config")
public interface SysConfigApi {
    /**
     * 系统设置接口
     * @param pageNo
     * @param pageSize
     * @param sysConfigPo
     * @return
     */
    @PostMapping("/list")
    PageResult list(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                    @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                    SysConfigPo sysConfigPo);
}
