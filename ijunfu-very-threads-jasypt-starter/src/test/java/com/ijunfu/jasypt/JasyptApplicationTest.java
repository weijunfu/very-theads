package com.ijunfu.jasypt;

import com.ijunfu.jasypt.config.UserConfig;
import jakarta.annotation.Resource;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/10 11:12
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@SpringBootTest
class JasyptApplicationTest {

    @Resource
    private UserConfig userConfig;

    @Test
    void userConfig() {
        System.out.println(userConfig.getName());
        System.out.println(userConfig.getPassword());
    }

    @Test
    void notEncrypt(@Autowired StringEncryptor stringEncryptor) {
        String name = stringEncryptor.encrypt(userConfig.getName());
        String password = stringEncryptor.encrypt(userConfig.getPassword());
        System.out.println(name);   // xCJp2jm6TXPRHjAsG6DgWZ38eA4N7NWUZbzMTnSs2KoUMIvAFZQMtTLN/k/A0g2/
        System.out.println(password);   // FrxjGPWsAQYvZFOFxZ+tScux7UTLH5v3zNUB5N9Q2inkQfc/SYCGFYm1Jbps6OZi

        String decrypted = stringEncryptor.decrypt(name);
        String decrypted1 = stringEncryptor.decrypt(password);

        assertEquals(userConfig.getName(), decrypted);
        assertEquals(userConfig.getPassword(), decrypted1);
    }

    @Test
    void decrypt() {
        System.out.println(userConfig.getName());
        System.out.println(userConfig.getPassword());
    }
}