package com.ijunfu.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * title  : 程序入口
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 22:27
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@SpringBootApplication
public class MdcApplication {

    public final static Logger log = LoggerFactory.getLogger(MdcApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(MdcApplication.class, args);
        log.info("Server...");
    }

}
