package com.ijunfu.starter.config;

import com.ijunfu.starter.interceptor.IpCounterInterceptor;
import com.ijunfu.starter.service.IpCounterService;
import com.ijunfu.starter.service.impl.IpCounterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 15:03
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@ComponentScan("com.ijunfu.starter.config")
public class IpAutoConfiguration {

    @Bean
    public IpCounterService ipCounterService() {
        return new IpCounterServiceImpl();
    }

    @Bean
    public IpCounterInterceptor interceptor(IpCounterService ipCounterService) {
        return new IpCounterInterceptor(ipCounterService);
    }

    @Bean
    public SpringMvcConfig springMvcConfig(IpCounterInterceptor interceptor) {
        return new SpringMvcConfig(interceptor);
    }
}
