package com.tingshuo.system.hystrix;

import com.tingshuo.system.fegin.ProductClient;
import org.springframework.stereotype.Component;

/**
 * 类文件描述:
 * 当使用openfeign调用其他服务时，其他服务异常时
 * 实现服务熔断，保护系统
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月02日 14:51
 **/
@Component
public class ProductClientHystrix implements ProductClient {
    @Override
    public String product() {
        return "当调用其他服务get请求无效时执行熔断";
    }
}
