package com.ijunfu.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 20:30
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
class RedPacketUtilTest {

    @Test
    void unpack() {

        List<Double> redPacketList = RedPacketUtil.unpack(100.00, 5);

        log.info("list: {}", redPacketList);
    }
}