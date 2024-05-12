package com.ijunfu.common.safe.enums;

/**
 *
 * @Title  : AES 支持的密钥长度
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 20:06
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public enum AESTagLengthEnum {
    L128(128),
    L120(120),
    L112(112),
    L104(104),
    L96(96);

    private int length;

    AESTagLengthEnum(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

}
