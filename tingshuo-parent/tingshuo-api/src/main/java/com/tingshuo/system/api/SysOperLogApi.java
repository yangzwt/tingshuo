package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.vo.SysOperLogVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 操作日志api接口
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 20:10
 **/
@RequestMapping("/operlog")
public interface SysOperLogApi {
    /**
     *
     * @param pageNo
     * @param pageSize
     * @param sysOperLogPo
     * @return
     */
    @PostMapping("/list")
    PageResult list(@RequestBody @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                    @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                    SysOperLogVO sysOperLogVO);
}
