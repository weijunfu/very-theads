package com.ijunfu.test.web;

import com.ijunfu.log.annotation.Log;
import com.ijunfu.log.enums.LogEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Title  : 首页控制器
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/31 10:19
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    @Log
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/emp/add")
    @Log(value = "添加员工", type = LogEnum.INSERT)
    public String addEmployee() {
        return "OK! add employee...";
    }

    @GetMapping("/emp/query")
    @Log(value = "查询员工", type = LogEnum.QUERY)
    public String queryEmployee() {
        return "OK! query employee...";
    }
}
