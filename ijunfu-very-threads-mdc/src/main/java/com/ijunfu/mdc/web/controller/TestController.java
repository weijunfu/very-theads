package com.ijunfu.mdc.web.controller;

import com.ijunfu.mdc.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 23:48
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public String hello() {
        log.info("Hello, World!");
        return "OK";
    }

    @GetMapping("/async")
    public String async() {
        testService.asyncTask();
        log.info("finish!");
        return "OK";
    }

    @GetMapping("/pool")
    public String threadPool() {

        return "OK";
    }
}
