package com.ijunfu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 19:55
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@RestController
@RequestMapping("/greeting")
public class HelloController {

    @GetMapping
    public Map<String, Object> greeting(@RequestBody UserVO vo) {
        Map<String, Object> map = new HashMap<>();
        map.put("author", vo.getName());
        return map;
    }
}
