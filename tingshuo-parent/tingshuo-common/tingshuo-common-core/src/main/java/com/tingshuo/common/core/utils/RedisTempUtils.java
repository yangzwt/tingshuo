package com.tingshuo.common.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * 类文件描述:
 * redis 操作的相关工具类
 * @author yangz
 * @version 1.0.0
 * @date 2022年10月13日 21:14
 **/
@Component
public class RedisTempUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisTempUtils(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置redis缓存失效时间
     *
     * @param key  键
     * @param time 失效时间
     * @return true 表示设置成功
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     * @param key 唯一的key不能为null
     * @return long 时间单位(秒) 返回的值 为0 代表永不失效
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 表示存在 false 表示不存在
     */
    public boolean hasKey(String key){
        try{
            redisTemplate.hasKey(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除redis对应的key
     * @param key 可以支持传输一个或者多个key值
     */
    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if (key!=null && key.length>0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
    /*String类型的操作*************************************************************/
    /**
     * 普通key的获取
     * @param key 对应的键
     * @return 是否为空
     */
    public Object get(String key){
        System.out.println(redisTemplate.opsForValue().get(key));
        return  key==null?null:redisTemplate.opsForValue().get(key);
    }
    /**
     * 普通缓存的存放
     * @param key 键
     * @param value 对应的值
     * @return true表示成功 false表示失败
     */

    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存的写入操作
     * @param key 对应的键
     * @param value 对应的值
     * @param time 超时时间 设置的time 要大于0，小于等于0表示永久有效
     * @return true 设置成功false设置失败
     */
    public boolean set(String key,Object value,long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置key续命
     * @param key
     * @param expire
     */
    public void setExpire(String key, long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }



    public static void main(String[] args) {

    }
}
