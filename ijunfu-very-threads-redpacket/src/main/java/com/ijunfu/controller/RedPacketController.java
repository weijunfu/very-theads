package com.ijunfu.controller;

import com.ijunfu.service.RedPacketService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 20:06
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@RestController
@RequestMapping("/red-packet")
public class RedPacketController {

    @Resource
    private RedPacketService redPacketService;


    @GetMapping("/unpack")
    public String unpack(
            @RequestParam("money") Double money,
            @RequestParam("total") Integer total
    ) throws IOException {

        return redPacketService.unpack(money, total);
    }
}
