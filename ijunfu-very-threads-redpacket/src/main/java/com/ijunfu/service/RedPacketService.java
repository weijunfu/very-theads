package com.ijunfu.service;

import com.ijunfu.common.id.NanoId;
import com.ijunfu.common.utils.JsonUtil;
import com.ijunfu.utils.RedPacketUtil;
import com.ijunfu.utils.RedisUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 20:10
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Service
public class RedPacketService {

    @Resource
    private RedisUtil redisUtil;

    public String unpack(Double money, Integer total) throws IOException {

        String redPacketKey = String.format("red-packet:%s", NanoId.randomNanoId());

        // 1. 预拆分红包
        List<Double> redPacketList = RedPacketUtil.unpack(money, total);

        // 2. 存入Redis
        redisUtil.lPush(redPacketKey, redPacketList);
        redisUtil.expire(redPacketKey, 60 * 60 * 24);

        // TODO 3. 监听红包过期，将过期的金额返还到余额


        return redPacketKey + "|" + JsonUtil.toJson(redPacketList);
    }
}
