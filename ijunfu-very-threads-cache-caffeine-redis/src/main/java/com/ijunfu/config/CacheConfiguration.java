package com.ijunfu.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Title  : 缓存配置类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/17 10:29
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@Configuration
@EnableCaching
public class CacheConfiguration {

    public final static String CACHE_LOCAL = "localCache";
    public final static String CACHE_REMOTE = "remoteCache";

    public CaffeineCacheManager localCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .maximumSize(1000)  // 设置最大缓存数量
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .removalListener((key, value, cause) -> {
                    switch (cause) {
                        case EXPIRED:
                            log.info("Entry expired: {}", key);
                            break;
                        case SIZE:
                            log.info("Entry evicted due to size limit: {}", key);
                            break;
                        default:
                            System.out.println("Entry removed: " + key);
                    }
                });

        cacheManager.setCaffeine(caffeine);
        cacheManager.setAllowNullValues(true);
        cacheManager.setCacheNames(Arrays.asList(CACHE_LOCAL));

        return cacheManager;
    }

    public RedisCacheManager remoteCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(5))
                        .prefixCacheNameWith("cr_");    // caffeine+redis

        RedisCacheManager.RedisCacheManagerBuilder redisCacheManagerBuilder =
                RedisCacheManager.RedisCacheManagerBuilder
                        .fromConnectionFactory(redisConnectionFactory)
                        .cacheDefaults(redisCacheConfiguration)
                        .initialCacheNames(Collections.singleton(CACHE_REMOTE));

        return redisCacheManagerBuilder.build();
    }

    @Bean
    public CacheManager cacheResolver(RedisConnectionFactory redisConnectionFactory) {

        Map<String, Cache> cacheMap = new HashMap<>();
        cacheMap.put(CACHE_LOCAL, localCacheManager().getCache(CACHE_LOCAL));
        cacheMap.put(CACHE_REMOTE, remoteCacheManager(redisConnectionFactory).getCache(CACHE_REMOTE));

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(cacheMap.values());

        return simpleCacheManager;
    }

    @Bean
    public CacheErrorHandler cacheErrorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException ex, Cache cache, Object key) {
                log.error("[{}] get {} cache error: {}", cache.getName(), key, ex.getMessage());
                throw new RuntimeException(ex);
            }

            @Override
            public void handleCachePutError(RuntimeException ex, Cache cache, Object key, Object value) {
                log.error("[{}] put {} cache error: {}", cache.getName(), key, ex.getMessage());
                throw new RuntimeException(ex);
            }

            @Override
            public void handleCacheEvictError(RuntimeException ex, Cache cache, Object key) {
                log.error("[{}] delete {} cache error: {}", cache.getName(), key, ex.getMessage());
                throw new RuntimeException(ex);
            }

            @Override
            public void handleCacheClearError(RuntimeException ex, Cache cache) {
                log.error("[{}] clear cache error: {}", cache.getName(), ex.getMessage());
                throw new RuntimeException(ex);
            }
        };
    }
}
