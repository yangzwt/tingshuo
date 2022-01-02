package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.param.SysPostPo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 岗位信息api接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 13:06
 **/
@RequestMapping("/post")
public interface SysPostApi {
    /**
     * 岗位分页查询接口
     * @param pageNo
     * @param pageSize
     * @param sysPostPo
     * @return
     */
    @PostMapping("/list")
    PageResult list(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                    @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                    SysPostPo sysPostPo);
}
