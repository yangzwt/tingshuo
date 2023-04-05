package com.tingshuo.system.api;

import com.tingshuo.common.core.web.entity.AjaxResult;
import com.tingshuo.system.vo.SysMenuVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类文件描述:
 * 菜单相关api
 * @author yangzong
 * @version 1.0.0
 * @date 2022年01月02日 9:58
 **/
@RequestMapping("/menu")
public interface SysMenuApi {
    @GetMapping("/list")
    AjaxResult list(SysMenuVO sysMenuVO);
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysMenuVO sysMenuVO);
}
