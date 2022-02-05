package com.tingshuo.gateway.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 类文件描述:
 * 自定义路由容错
 * 处理未定义的路由
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月04日 14:55
 **/
@RestController
public class NotFoundConrtoller {
    @GetMapping("/notfound")
    public Mono<Map<String,String>> notfound(){
        Map <String,String>map = new HashMap<String,String>();
        map.put("code","404");
        map.put("data","NotFound");
        return Mono.just(map);
    }
}
