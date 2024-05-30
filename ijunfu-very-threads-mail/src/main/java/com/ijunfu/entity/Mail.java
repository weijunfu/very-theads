package com.ijunfu.entity;

import lombok.Data;

/**
 *
 * @Title  : 邮件对象
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/24 17:56
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
public class Mail {

    /**
     * 发件人
     */
    private String from;

    /**
     * 收件人
     */
    private String to;

    /**
     * 抄送
     */
    private String cc;

    /**
     * 密送
     */
    private String bcc;

    /**
     * 标题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

}
