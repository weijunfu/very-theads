package com.ijunfu.common.id;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


/**
 *
 * @Title  : NanoId 测试类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 19:14
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */

@Slf4j
class NanoIdTest {

    @Test
    void testId() {

        String id = NanoId.randomNanoId();
        log.info("默认长度id：{}", id);

        id = NanoId.randomNanoId(16);
        log.info("指定长度id：{}", id);
    }
    
    @Test
    void testBatch() {
        for (int i = 0; i < 100; i++) {
            String id = NanoId.randomNanoId();
            log.info("{}. 默认长度id：{}", i, id);
        }
    }
}