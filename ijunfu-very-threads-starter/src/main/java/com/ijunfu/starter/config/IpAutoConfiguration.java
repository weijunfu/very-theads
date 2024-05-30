package com.ijunfu.starter.config;

import com.ijunfu.starter.interceptor.IpCounterInterceptor;
import com.ijunfu.starter.service.IpCounterService;
import com.ijunfu.starter.service.impl.IpCounterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title : 自动配置类
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 15:03
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@ComponentScan("com.ijunfu.starter.config")     // 扫描自定义配置类
public class IpAutoConfiguration {

    /**
     * @Title  : 注册业务类
     *
     * @Param	:
     * @Return : com.ijunfu.starter.service.IpCounterService
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:02
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public IpCounterService ipCounterService() {
        return new IpCounterServiceImpl();
    }

    /**
     * @Title  : 注册拦截器类
     *
     * @Param	: ipCounterService
     * @Return : com.ijunfu.starter.interceptor.IpCounterInterceptor
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:02
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public IpCounterInterceptor interceptor(IpCounterService ipCounterService) {
        return new IpCounterInterceptor(ipCounterService);
    }

    /**
     * @Title  : 注入拦截器
     *
     * @Param	: interceptor
     * @Return : com.ijunfu.starter.config.SpringMvcConfig
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:03
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public SpringMvcConfig springMvcConfig(IpCounterInterceptor interceptor) {
        return new SpringMvcConfig(interceptor);
    }
}
