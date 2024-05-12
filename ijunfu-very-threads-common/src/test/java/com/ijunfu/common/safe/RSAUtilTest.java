package com.ijunfu.common.safe;

import com.ijunfu.common.safe.enums.AESTagLengthEnum;
import com.ijunfu.common.safe.enums.AESTransformationEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 16:44
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
class RSAUtilTest {

    static KeyPair keyPair;

    private static final String AES_KEY = "P4wiGBvk6gcLcLGMWAOXPQDnwZqqXLPR";

    private static String publicKey;

    private static String privateKey;


    @BeforeAll
    static void beforeAll() {
        keyPair = RSAUtil.genKeyPair(2048);

        publicKey = RSAUtil.getPublicKeyString(keyPair);

        privateKey = RSAUtil.getPrivateKeyString(keyPair);
    }

    @Test
    void encryptAndDecrypt() {
        String encryptedHex = RSAUtil.encrypt(keyPair.getPublic(), "ijunfu");
        log.info("原文本：{}", "ijunfu");
        log.info("加密后的文本：{}", encryptedHex);

        String decryptedText = RSAUtil.decrypt(keyPair.getPrivate(), encryptedHex);
        log.info("解密后的文本：{}", decryptedText);
    }

    @Test
    void encryptAndDecrypt2() {
        String encryptedHex = RSAUtil.encrypt(publicKey, "ijunfu");
        log.info("原文本：{}", "ijunfu");
        log.info("加密后的文本：{}", encryptedHex);

        String decryptedText = RSAUtil.decrypt(privateKey, encryptedHex);
        log.info("解密后的文本：{}", decryptedText);
    }
}