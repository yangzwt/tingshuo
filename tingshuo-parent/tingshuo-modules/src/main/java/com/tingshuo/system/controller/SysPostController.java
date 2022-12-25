package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysPostApi;
import com.tingshuo.system.entity.SysPost;
import com.tingshuo.system.vo.SysPostVO;
import com.tingshuo.system.service.ISysPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 岗位信息业务
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 13:34
 **/
@RestController
public class SysPostController implements SysPostApi {
    @Autowired
    private ISysPostService sysPostService;
    /**
     * 岗位信息分页查询
     * @param pageNo
     * @param pageSize
     * @param sysPostPo
     * @return
     */
    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysPostVO sysPostPo) {
        SysPost sysPost = new SysPost();
        BeanUtils.copyProperties(sysPostPo,sysPost);//对象拷贝
        return sysPostService.list(pageNo,pageSize,sysPost);
    }
}
