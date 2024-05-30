package com.ijunfu.utils;

import com.ijunfu.common.id.NanoId;
import com.ijunfu.entity.Mail;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/24 18:02
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MailUtilTest {

    @Resource
    private MailUtil mailUtil;

    /**
     * @Title  : 发送普通邮件
     *
     * @Param	:
     * @Return : void
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/24 18:12
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Test
    void sendMail_plainText() {
        Mail mail = new Mail();

        mail.setFrom("ijunfu@sina.com");
        mail.setTo("ijunfu@163.com");
        mail.setCc("tesila.cn@gmail.com");
        mail.setBcc("ijunfu@qq.com");
        mail.setSubject("测试邮件" + NanoId.randomNanoId(8));
        mail.setContent("测试邮件内容: " + NanoId.randomNanoId());

        mailUtil.sendMail(mail);
    }

    @Test
    void sendMail_attachment() {
        Mail mail = new Mail();

        mail.setFrom("ijunfu@sina.com");
        mail.setTo("ijunfu@163.com");
        mail.setCc("tesila.cn@gmail.com");
        mail.setBcc("ijunfu@qq.com");
        mail.setSubject("测试邮件" + NanoId.randomNanoId(8));
        mail.setContent("测试邮件内容: " + NanoId.randomNanoId());

        List<File> list = Arrays.asList(new File("C:\\Users\\ijunfu\\Pictures\\兔.png"), new File("C:\\Users\\ijunfu\\Pictures\\www.uugai.com-817716(已去底).png"));

        mailUtil.sendMail(mail, list);
    }
}