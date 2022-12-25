package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.vo.SysLoginInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 系统访问日志api
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:09
 **/
@RequestMapping("/loginInfo")
public interface SysLoginInfoApi {
    /**
     * 系统登录日志查询
     * @param pageNo
     * @param pageSize
     * @param sysLoginInforPo
     * @return
     */
    @PostMapping("/list")
    PageResult list(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                    @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                    SysLoginInfoVO sysLoginInfoVO);
}
