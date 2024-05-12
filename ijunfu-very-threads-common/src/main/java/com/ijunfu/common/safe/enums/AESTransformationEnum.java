package com.ijunfu.common.safe.enums;

/**
 *
 * @Title  : AES支持的密钥填充算法
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 17:47
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public enum AESTransformationEnum {

    ECB("AES/ECB/PKCS5Padding"),
    CBC("AES/CBC/PKCS5Padding"),
    GCM("AES/GCM/NoPadding");

    private String transformation;

    AESTransformationEnum(String transformation) {
        this.transformation = transformation;
    }

    public String getTransformation() {
        return transformation;
    }
}
