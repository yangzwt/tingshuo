package com.tingshuo.system.controller;

import com.tingshuo.common.core.result.PageResult;
import com.tingshuo.system.api.SysDeptApi;
import com.tingshuo.system.entity.SysDept;
import com.tingshuo.system.vo.SysDeptVO;
import com.tingshuo.system.service.ISysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 * 机构信息业务
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月02日 12:34
 **/
@RestController
public class SysDeptController implements SysDeptApi {
    private Logger logger = LoggerFactory.getLogger(SysDeptController.class);
    @Autowired
    private ISysDeptService sysDeptService;
    /**
     * 机构信息查询
     * @param pageNo
     * @param pageSize
     * @param sysDeptPo
     * @return
     */

    @Override
    public PageResult list(Integer pageNo, Integer pageSize, SysDeptVO sysDeptPo) {
        SysDept sysDept=new SysDept();
        BeanUtils.copyProperties(sysDeptPo,sysDept);//对象拷贝
        logger.info("使用日志打印。并进行日志链路追踪sleuth");
        return sysDeptService.list(pageNo,pageSize,sysDept);
    }
}
