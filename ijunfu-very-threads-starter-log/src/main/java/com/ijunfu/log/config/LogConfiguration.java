package com.ijunfu.log.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title  : 日志配置类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/31 10:00
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */

@Configuration
@ConfigurationProperties(prefix = "log")
public class LogConfiguration {

    private Boolean enable;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
