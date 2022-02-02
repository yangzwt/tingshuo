package com.tingshuo.system.fegin;

import com.tingshuo.system.hystrix.ProductClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类文件描述:
 * @FeignClient("tingshuo-activity")
 * 表示注册中中心的名字，不能加/
 * 新增fallback,进行 服务容错处理
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月02日 11:05
 **/
@FeignClient(value = "tingshuo-activity",fallback = ProductClientHystrix.class)
public interface ProductClient {
    @GetMapping("/getString")
    String product();
}
