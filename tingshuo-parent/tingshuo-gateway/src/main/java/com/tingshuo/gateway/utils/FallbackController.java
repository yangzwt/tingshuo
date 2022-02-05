package com.tingshuo.gateway.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月04日 15:17
 **/
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public Mono<Map<String,String>> notfound(){
        Map <String,String>map = new HashMap<String,String>();
        map.put("code","100");
        map.put("data","Service Not Avaiable");
        map.put("msg","路由进行了容错hystrix处理");
        return Mono.just(map);
    }
}
