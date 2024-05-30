package com.ijunfu.enable.config;

import com.ijunfu.enable.interceptor.MyInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 20:11
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

    private final MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**");
    }
}
