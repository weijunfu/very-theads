package com.ijunfu.enable.autoconfigure;

import com.ijunfu.enable.config.ShowInfoConfiguration;
import com.ijunfu.enable.config.WebConfiguration;
import com.ijunfu.enable.interceptor.MyInterceptor;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 20:06
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@ConditionalOnProperty(name = "my.enable", matchIfMissing = false)  // my.enable 默认值为false
@ComponentScan("com.ijunfu.enable.config")
public class ShowInfoAutoConfiguration {

    @Resource
    private ShowInfoConfiguration showInfoConfiguration;

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor(showInfoConfiguration);
    }

    @Bean
    public WebConfiguration webConfiguration(MyInterceptor myInterceptor) {
        return new WebConfiguration(myInterceptor);
    }
}
