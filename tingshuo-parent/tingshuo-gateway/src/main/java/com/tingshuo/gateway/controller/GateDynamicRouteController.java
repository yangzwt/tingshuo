package com.tingshuo.gateway.controller;

//import com.tingshuo.gateway.utils.GatewayDynamicRouteService;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月04日 18:08
 **/
/*@RestController
@RequestMapping("/gateway")
public class GateDynamicRouteController {
    @Resource
    private GatewayDynamicRouteService gatewayDynamicRouteService;

    @PostMapping("/add")
    public String create(@RequestBody RouteDefinition routeDefinition){
        int result=gatewayDynamicRouteService.add(routeDefinition);
        return String.valueOf(result);
    }
    @PostMapping("/upate")
    public String update(@RequestBody RouteDefinition routeDefinition){
        int result=gatewayDynamicRouteService.update(routeDefinition);
        return String.valueOf(result);
    }
    @PostMapping("/delete/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id){
        return gatewayDynamicRouteService.delete(id);
    }

}*/
