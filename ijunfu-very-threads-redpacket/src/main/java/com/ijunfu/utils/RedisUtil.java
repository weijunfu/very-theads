package com.ijunfu.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 17:26
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 设置键值对（String类型）
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 获取键对应的值（String类型）
    public String getString(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    // 设置键值对（Integer类型）
    public void setInteger(String key, Integer value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 获取键对应的值（Integer类型）
    public Integer getInteger(String key) {
        return (Integer) redisTemplate.opsForValue().get(key);
    }

    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key).longValue();
    }

    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta).longValue();
    }

    // 删除键
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // 检查键是否存在
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    // 设置键的有效期（单位：秒）
    public void expire(String key, long seconds) {
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    // 哈希操作（Map类型）
    public void hSet(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // 列表操作（List类型）
    public void lPush(String key, List<Object> list) {
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    // 列表操作（List类型）
    public void lPush(String key, Object val) {
        redisTemplate.opsForList().rightPush(key, val);
    }

    public List<Object> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }
}
