package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.param.SysDeptPo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 机构部门信息api
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 12:25
 **/
@RequestMapping("/dept")
public interface SysDeptApi {
    /**
     * 机构信息查询
     * @param sysDeptPo
     * @return
     */
    @PostMapping("/list")
    PageResult list(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                    @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                    SysDeptPo sysDeptPo);
}
