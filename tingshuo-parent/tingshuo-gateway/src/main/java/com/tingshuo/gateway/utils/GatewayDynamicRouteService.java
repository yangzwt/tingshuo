package com.tingshuo.gateway.utils;

/**
 * 类文件描述:
 *
 * @author yangz
 * @version 1.0.0
 * @date 2022年02月04日 17:56
 **/
/*@Service
public class GatewayDynamicRouteService implements ApplicationEventPublisherAware {
    @Resource
    private RedisRouteDefinitionRepository redisRouteDefinitionRepository;

    private ApplicationEventPublisher applicationEventPublisher;

    public int add(RouteDefinition routeDefinition){
        redisRouteDefinitionRepository.save(Mono.just(routeDefinition)).subscribe();
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
        return 1;
    }
    public int update(RouteDefinition routeDefinition){
        redisRouteDefinitionRepository.delete(Mono.just(routeDefinition.getId()));
        redisRouteDefinitionRepository.save(Mono.just(routeDefinition)).subscribe();
        return 1;
    }
    public Mono<ResponseEntity<Object>> delete(String id){
        return redisRouteDefinitionRepository.delete(Mono.just(id)).then(Mono.defer(()->Mono.just(ResponseEntity.ok().build()))).onErrorResume(t-> t instanceof NotFoundException,t->Mono.just(ResponseEntity.notFound().build()));
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
}*/
