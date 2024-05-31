package com.ijunfu.log.autoconfigure;

import com.ijunfu.log.aspect.LogAspect;
import com.ijunfu.log.config.LogConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @Title  : 日志自动配置类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/31 10:14
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@EnableAspectJAutoProxy
@Configuration
@ConditionalOnProperty(prefix = "log", name = "enable", matchIfMissing = true)
@ComponentScan("com.ijunfu.log.config")
public class LogAutoConfiguration {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
