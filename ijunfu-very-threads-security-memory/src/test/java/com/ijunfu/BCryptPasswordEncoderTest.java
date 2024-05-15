package com.ijunfu;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/15 11:16
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@SpringBootTest
public class BCryptPasswordEncoderTest {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    void genEncoderPassword() {
        PasswordEncoder encoder = PasswordEncoderFactories. createDelegatingPasswordEncoder();
        // outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy. fqvM/ BG
        // remember the password that is printed out and use in the next step
        System. out. println(passwordEncoder.encode("123456"));
    }
}
