package com.ijunfu.test;

import com.ijunfu.starter.service.IpCounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 17:21
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@Slf4j
@RestController
@RequestMapping("/ip")
@RequiredArgsConstructor
public class IPController {

    @GetMapping("/counter")
    public String counter() {
        return "OK";
    }
}
