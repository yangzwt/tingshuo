package com.tingshuo.system.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类文件描述:
 * @FeignClient("tingshuo-activity")
 * 表示注册中中心的名字，不能加/
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月02日 11:05
 **/
@FeignClient("tingshuo-activity")
public interface ProductClient {
    @GetMapping("/getString")
    String product();
}
