package com.ijunfu.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 20:22
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@RequestMapping("/")
@RestController
public class GreetingController {

    @GetMapping
    public String greeting() {
        return "Hello, World!";
    }
}
