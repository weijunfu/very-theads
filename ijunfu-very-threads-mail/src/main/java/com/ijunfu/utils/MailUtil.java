package com.ijunfu.utils;

import com.ijunfu.entity.Mail;
import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @Title  : 邮件发送工具类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/24 17:56
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@Component
public class MailUtil {

    @Resource
    private JavaMailSender javaMailSender;

    /**
     * @Title  : 发送普通邮件
     *
     * @Param	: mail
     * @Return : void
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/24 18:14
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    public void sendMail(Mail mail) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getFrom());
        message.setTo(mail.getTo());
        message.setCc(mail.getCc());
        message.setBcc(mail.getBcc());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        javaMailSender.send(message);
    }

    public void sendMail(Mail mail, List<File> files) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(mail.getTo());
            messageHelper.setCc(mail.getCc());
            messageHelper.setBcc(mail.getBcc());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mail.getContent());

            for(File file : files) {
                messageHelper.addAttachment(
                        MimeUtility.encodeText(file.getName(), StandardCharsets.UTF_8.name(), null),
                        file
                );
            }
            javaMailSender.send(message);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
