package com.tingshuo.gateway.utils;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月04日 17:38
 **/
/*@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {
    public static final String gateWay="gateway_dynamic_route";
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions=new ArrayList<>();
        stringRedisTemplate.opsForHash().values(gateWay).stream()
                .forEach(routeDefinition->
                        routeDefinitions.add(JSON.parseObject(routeDefinition.toString(),RouteDefinition.class)));
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            stringRedisTemplate.opsForHash().put(gateWay,routeDefinition.getId(), JSONObject.toJSONString(routeDefinition));
        return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {

        return routeId.flatMap(id->{
            if (stringRedisTemplate.opsForHash().hasKey(gateWay,id)){
                stringRedisTemplate.opsForHash().delete(gateWay,id);
                return Mono.empty();
            }
            return Mono.defer(()->Mono.error(new NotFoundException("route definition is not foiund,routeID:"+routeId)));
        });
    }
}*/
