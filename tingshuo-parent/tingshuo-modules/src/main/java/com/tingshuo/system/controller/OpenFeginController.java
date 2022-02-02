package com.tingshuo.system.controller;

import com.tingshuo.system.fegin.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月02日 11:03
 **/
@RestController
public class OpenFeginController {
    private Logger logger = LoggerFactory.getLogger(OpenFeginController.class);
    @Autowired
    private ProductClient productClient;
    @GetMapping("/getString")
    public String modulesOpenFeign(){
        //声明使用openfeign进行接口调用
        String product = productClient.product();
        logger.info("服务方返回数据="+product);
        return product;
    }

}
