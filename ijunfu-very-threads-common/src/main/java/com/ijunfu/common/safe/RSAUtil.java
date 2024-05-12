package com.ijunfu.common.safe;

import com.ijunfu.common.exception.SafeException;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HexFormat;

/**
 *
 * @Title  : RSA 加密工具类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 16:05
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public final class RSAUtil {

    public final static String ALGORITHM_RSA = "RSA";

    public final static String TRANSFORMATION_RSA = "RSA/ECB/PKCS1Padding";

    private RSAUtil(){}

    /**
     * @Title  : 生成密钥对
     *
     * @Param	: keyLength 密钥长度
     * @Return : java.security.KeyPair 密钥对
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/11 20:32
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    public static KeyPair genKeyPair(int keyLength) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
            keyPairGenerator.initialize(keyLength);

            return keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new SafeException(e);
        }
    }

    /**
     * @Title  : 获取公钥字符串
     *
     * @Param	: keyPair 密钥对
     * @Return : java.lang.String 公钥字符串
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/11 20:33
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    public static String getPublicKeyString(KeyPair keyPair) {
        return HexFormat.of().formatHex(getPublicKey(keyPair));
    }

    public static byte[] getPublicKey(KeyPair keyPair) {
        return keyPair.getPublic().getEncoded();
    }

    public static PublicKey toPublicKeyString(String publicKey) {
        try {
            byte[] bytes = HexFormat.of().parseHex(publicKey);

            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytes);

            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (Exception e) {
            throw new SafeException(e);
        }
    }

    public static PrivateKey toPrivateKey(String privateKey) {
        try {
            byte[] bytes = HexFormat.of().parseHex(privateKey);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);

            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            throw new SafeException(e);
        }
    }

    /**
     * @Title  : 获取私钥字符串
     *
     * @Param	: keyPair 密钥对
     * @Return : java.lang.String 私钥字符串
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/11 20:34
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    public static String getPrivateKeyString(KeyPair keyPair) {
        return HexFormat.of().formatHex(getPrivateKey(keyPair));
    }

    public static byte[] getPrivateKey(KeyPair keyPair) {
        return keyPair.getPrivate().getEncoded();
    }

    /**
     * 公钥加密
     * @param publicKey 公钥
     * @param plainText 明文
     * @return 密文
     */
    public static String encrypt(PublicKey publicKey,String plainText) {
        byte[] encryptedBytes = encrypt(publicKey, plainText.getBytes(StandardCharsets.UTF_8));

        return HexFormat.of().formatHex(encryptedBytes);
    }

    public static String encrypt(String publicKey, String plainText) {
        return encrypt(toPublicKeyString(publicKey), plainText);
    }

    /**
     * 公钥加密
     * @param publicKey 公钥
     * @param bytes 明文字节数组
     * @return 密文
     */
    public static byte[] encrypt(PublicKey publicKey,byte[] bytes) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(bytes);
        } catch (Exception e) {
            throw new SafeException(e);
        }
    }

    /**
     * 私钥解密
     * @param privateKey 私钥
     * @param hexText 密文，加密后字节数组转成十六进制字符串
     * @return 明文
     */
    public static String decrypt(PrivateKey privateKey, String hexText) {
        byte[] decryptedBytes = decrypt(privateKey, HexFormat.of().parseHex(hexText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static String decrypt(String privateKey, String hexText) {
        return decrypt(toPrivateKey(privateKey), hexText);
    }

    /**
     * 私钥解密
     * @param privateKey 私钥
     * @param encryptedBytes 密文字节数组
     * @return 明文
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] encryptedBytes) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION_RSA);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(encryptedBytes);
        } catch (Exception e) {
            throw new SafeException(e);
        }
    }
}
