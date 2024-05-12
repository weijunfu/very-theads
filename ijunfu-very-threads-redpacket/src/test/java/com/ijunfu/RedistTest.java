package com.ijunfu;

import com.ijunfu.common.utils.JsonUtil;
import com.ijunfu.utils.RedisUtil;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 15:55
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@SpringBootTest
public class RedistTest {

    @Resource
    private RedisUtil redisUtil;

    @Test
    void testInteger() {
        String key = "blog:view:123";

        redisUtil.setInteger(key, 1);

        Integer val = redisUtil.getInteger(key);
        log.info("{}={}", key, val);

        Long newVal = redisUtil.increment(key);
        log.info("{}={}", key, newVal);

        newVal = redisUtil.increment(key, 5);
        log.info("{}={}", key, newVal);
    }

    @Test
    void testList() throws IOException {
        String key = "blog:view:usr";

        redisUtil.lPush(key, 10);

        redisUtil.lPush(key, Arrays.asList(35, 20, 40, 15));

        List<Object> list = redisUtil.lRange(key, 0, -1);

        log.info("{}", JsonUtil.toJson(list));
    }
}
