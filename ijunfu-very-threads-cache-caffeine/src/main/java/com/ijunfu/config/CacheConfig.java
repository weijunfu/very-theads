package com.ijunfu.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
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
public class CacheConfig {

    @Bean
    public CaffeineCacheManager cacheManager() {
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
        cacheManager.setCacheNames(Arrays.asList("sys", "test", "demo"));

        return cacheManager;
    }
}
