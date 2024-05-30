package com.ijunfu.starter.service.impl;

import com.ijunfu.starter.config.IpConfiguration;
import com.ijunfu.starter.service.IpCounterService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title : Ip计数器服务类接口实现类
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 14:57
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@Slf4j
public class IpCounterServiceImpl implements IpCounterService {
    
    @Resource
    private HttpServletRequest request;

    @Resource
    private IpConfiguration ipConfiguration;
    
    private Map<String, Integer> map = new HashMap<>();
    
    @Override
    public void record() {
        // ip
        String ip = request.getRemoteAddr();

        // 访问次数
        Integer counter = map.getOrDefault(ip, 0);

        // 更新
        map.put(ip, counter + 1);

        // 输出
        map.forEach((key, value) -> {
            if(ipConfiguration.getDisplay().equals(IpConfiguration.Display.SIMPLE.getValue())) {
                log.info("ip: {}\tcount:{}", key, value);
            } else {
                log.info("\t\tIp访问监控");
                log.info("+------------------------------------+");
                log.info("|{}\t\t{}", key, value);
                log.info("+------------------------------------+");
            }

        });
    }
}
