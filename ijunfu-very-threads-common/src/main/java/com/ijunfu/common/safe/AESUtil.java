package com.ijunfu.common.safe;

import com.ijunfu.common.exception.SafeException;
import com.ijunfu.common.safe.enums.AESTagLengthEnum;
import com.ijunfu.common.safe.enums.AESTransformationEnum;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.Optional;

/**
 *
 * @Title  : AES 加密、解密工具类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 17:30
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public final class AESUtil {

    private AESUtil(){}

    public final static String ALGORITHM_AES = "AES";

    public final static int IV_SIZE = 16;

    public final static int NONCE_SIZE = 12;

    public static String encrypt(
            AESTransformationEnum transformation,
            String key,
            String plainText,
            Optional<AESTagLengthEnum> lengthOptional) {
        byte[] encryptedBytes =
                encrypt(transformation, key, plainText.getBytes(StandardCharsets.UTF_8), lengthOptional);

        return HexFormat.of().formatHex(encryptedBytes);
    }

    public static byte[] encrypt(
            AESTransformationEnum transformation,
            String key,
            byte[] bytes,
            Optional<AESTagLengthEnum> lengthOptional) {

        try {
            SecureRandom random = new SecureRandom();
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance(transformation.getTransformation());

            byte[] result = null;

            switch (transformation) {
                case ECB:
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                    result = cipher.doFinal(bytes);
                    break;
                case CBC:
                    byte[] iv = new byte[IV_SIZE];
                    random.nextBytes(iv);
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
                    result = concatArrays(iv, cipher.doFinal(bytes));
                    break;
                case GCM:

                    if(lengthOptional.isEmpty()) {
                        throw new SafeException("[AES-GCM] not length found");
                    }

                    byte[] nonce = new byte[NONCE_SIZE]; // 96-bit nonce
                    random.nextBytes(nonce);

                    GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(lengthOptional.get().getLength(), nonce);
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);
                    result = concatArrays(nonce, cipher.doFinal(bytes));
                    break;
            }

            return result;
        } catch (Exception e) {
            throw new SafeException(e);
        }
    }

    public static String decrypt(
            AESTransformationEnum transformation,
            String key,
            String encryptedHex,
            Optional<AESTagLengthEnum> lengthOptional) {
        byte[] decryptedBytes = decrypt(transformation, key, HexFormat.of().parseHex(encryptedHex), lengthOptional);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static byte[] decrypt(
            AESTransformationEnum transformation,
            String key,
            byte[] encryptedBytes,
            Optional<AESTagLengthEnum> lengthOptional) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance(transformation.getTransformation());

            byte[] result = null;

            switch (transformation) {
                case ECB:
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                    result = cipher.doFinal(encryptedBytes);
                    break;
                case CBC:
                    {
                        byte[] iv = new byte[IV_SIZE];
                        byte[] bytes = new byte[encryptedBytes.length - iv.length];

                        System.arraycopy(encryptedBytes, 0, iv, 0, iv.length);
                        System.arraycopy(encryptedBytes, iv.length, bytes, 0, bytes.length);

                        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
                        result = cipher.doFinal(bytes);
                    }
                    break;
                case GCM:
                    {
                        if(lengthOptional.isEmpty()) {
                            throw new SafeException("[AES-GCM] No value present");
                        }
                        byte[] nonce = new byte[NONCE_SIZE];
                        byte[] bytes = new byte[encryptedBytes.length - nonce.length];

                        System.arraycopy(encryptedBytes, 0, nonce, 0, nonce.length);
                        System.arraycopy(encryptedBytes, nonce.length, bytes,0, bytes.length);

                        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(lengthOptional.get().getLength(), nonce);
                        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
                        result = cipher.doFinal(bytes);
                    }
                    break;
            }

            return result;
        } catch (Exception e) {
            throw new SafeException(e);
        }
    }

    /**
     * @Title  : 合并两个字节数组
     *
     * @Param	: a 第一个字节数组
	 * @Param	: b 第二个字节数组
     * @Return : byte[] 合并后的新数组
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/11 19:08
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    private static byte[] concatArrays(byte[] a, byte[] b) {
        byte[] c = new byte[a.length + b.length];

        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        return c;
    }
}
