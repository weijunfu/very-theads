package com.ijunfu.common.web;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title  : 安全返回对象，raw是经过加密后的密文
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 21:41
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
public class SafeResult implements Serializable {

    private String raw;

}
