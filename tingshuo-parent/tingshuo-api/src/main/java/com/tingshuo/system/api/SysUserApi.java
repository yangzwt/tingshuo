package com.tingshuo.system.api;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.vo.SysUserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类文件描述:
 * 用户接口api
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月15日 19:50
 **/

@RequestMapping("/user")
public interface SysUserApi {
    /**
     * 用户查询列表
     * @param pageNo
     * @param pageSize
     * @param SysUserPo
     * @return
     */
    @PostMapping("/list")
    PageResult selectUserPageList(@RequestBody  @RequestParam(name="pageNo" ,defaultValue = "1") Integer pageNo,
                                         @RequestParam(name="pageSize",defaultValue = "15") Integer pageSize,
                                         SysUserVO sysUserVO);

}
