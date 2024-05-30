package com.ijunfu.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 18:21
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ip")
public class IpConfiguration {

    private String display = Display.SIMPLE.getValue();

    public enum Display {
        SIMPLE("simple"), DETAIL("detail");

        private String value;

        Display(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
