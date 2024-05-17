package com.ijunfu.controller;

import com.ijunfu.entity.SysUser;
import com.ijunfu.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/17 14:20
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list() {
        return sysUserService.list();
    }

    @PostMapping
    public String save(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return "OK";
    }

    @GetMapping
    public SysUser getById(@RequestParam Long userId) {
        return sysUserService.getById(userId);
    }

    @PutMapping
    public String update(@RequestBody SysUser sysUser) {
        sysUserService.updateById(sysUser);
        return "OK";
    }

    @DeleteMapping
    public String delete(@RequestParam Long userId) {
        sysUserService.removeById(userId);
        return "OK";
    }
}
