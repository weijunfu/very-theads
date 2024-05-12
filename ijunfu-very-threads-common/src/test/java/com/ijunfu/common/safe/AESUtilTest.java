package com.ijunfu.common.safe;

import com.ijunfu.common.safe.enums.AESTagLengthEnum;
import com.ijunfu.common.safe.enums.AESTransformationEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 17:54
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
class AESUtilTest {

    private final static String AES_KEY = "P4wiGBvk6gcLcLGMWAOXPQDnwZqqXLPR";

    @Test
    void encryptAndDecrypt() {
        String plainText = "ijunfu";
        log.info("原文本：{}", plainText);

        Arrays.stream(AESTransformationEnum.values())
                .filter(transformation -> transformation != AESTransformationEnum.GCM)
                .forEach(transformation -> {
                    String encrypted = AESUtil.encrypt(transformation, AES_KEY, plainText, Optional.empty());
                    log.info("填充模式：{}\t\t加密后：{}", transformation, encrypted);

                    String decrypted = AESUtil.decrypt(transformation, AES_KEY, encrypted,Optional.empty());
                    log.info("填充模式：{}\t\t解密后：{}", transformation, decrypted);
                });

        Arrays.stream(AESTagLengthEnum.values()).forEach(length -> {
            String encrypted = AESUtil.encrypt(AESTransformationEnum.GCM, AES_KEY, plainText, Optional.of(length));
            log.info("填充模式：{}\t\t密钥长度：{}\t\t加密后：{}", AESTransformationEnum.GCM, length.getLength(), encrypted);

            String decrypted = AESUtil.decrypt(AESTransformationEnum.GCM, AES_KEY, encrypted, Optional.of(length));
            log.info("填充模式：{}\t\t密钥长度：{}\t\t解密后：{}", AESTransformationEnum.GCM, length.getLength(), decrypted);
        });
    }

}