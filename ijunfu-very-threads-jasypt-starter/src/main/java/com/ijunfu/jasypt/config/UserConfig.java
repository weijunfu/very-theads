package com.ijunfu.jasypt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * title  : 用户配置类
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/10 11:19
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
