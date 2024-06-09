package com.ijunfu.mdc.config;

import com.ijunfu.mdc.filter.MdcFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * title  : 过滤器配置文件
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 22:43
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Configuration
public class FilterConfig {

    /***
     * title  : 注册日志追踪过滤器
     * author : ijunfu <ijunfu@163.com>
     * date   : 2024/6/8 22:46
     * version: 1.0
     * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public FilterRegistrationBean<MdcFilter> loggingFilter() {
        FilterRegistrationBean<MdcFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new MdcFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
