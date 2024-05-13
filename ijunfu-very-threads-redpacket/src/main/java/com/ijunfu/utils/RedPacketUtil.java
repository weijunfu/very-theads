package com.ijunfu.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 *
 * @Title  : 红包工具类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 20:20
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class RedPacketUtil {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static final String RED_PACKET_UNPACK_SCRIPT = "lua/unpack.lua";
    public static final String RED_PACKET_AMOUNT_PREFIX_KEY = "red-packet:amount:";
    public static final String RED_PACKET_TOTAL_PREFIX_KEY = "red-packet:total:";
    public static final String RED_PACKET_CONSUMER_PREFIX_KEY = "red-packet:consumer:";

    /**
     * @Title  : 预分配拆红包
     *
     * @Param	: totalAmount   总金额
     * @Param	: total         总红包数
     * @Return : java.util.List<java.lang.Double>
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/12 21:01
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    public static List<Double> unpack(Double totalAmount, Integer total) {

        List<Double> redPacketList = new Vector<>();

        // 总金额
        double restAmount = totalAmount;

        // 总人数
        double restTotal = total;

        for(int i = 0; i<total-1; i++) {
            double amount = RANDOM.nextDouble() * 2 * restAmount / restTotal;

            amount = Math.max(0.01,  format(amount));

            restAmount -= amount;
            restTotal--;

            redPacketList.add(amount);
        }

        redPacketList.add(format(restAmount));

        return redPacketList;
    }

    public static String unpack(RedisTemplate redisTemplate,String idRedPacket, Long idUser) throws IOException {

        String unpackScript = IOUtils.toString(new ClassPathResource(RED_PACKET_UNPACK_SCRIPT).getInputStream());

        RedisScript<String> script = new DefaultRedisScript<>(unpackScript, String.class);

        return (String) redisTemplate.execute(
                script,
                Arrays.asList(
                        RED_PACKET_AMOUNT_PREFIX_KEY + idRedPacket,
                        RED_PACKET_TOTAL_PREFIX_KEY + idRedPacket,
                        RED_PACKET_CONSUMER_PREFIX_KEY + idRedPacket
                ),
                idUser
        );
    }

    public static Double format(Double amount) {
        return Double.parseDouble(String.format("%.2f", amount));
    }
}
