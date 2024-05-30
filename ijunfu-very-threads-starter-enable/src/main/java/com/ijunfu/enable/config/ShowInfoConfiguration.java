package com.ijunfu.enable.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 20:03
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "my")
public class ShowInfoConfiguration {

    private Boolean enable;
    private String info;

}
