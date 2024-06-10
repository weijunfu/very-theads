package com.ijunfu.jasypt;

import org.apache.commons.codec.binary.Hex;
import org.jasypt.util.digest.Digester;
import org.jasypt.util.numeric.BasicIntegerNumberEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/9 20:52
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
class JasyptDemoTest {

    public static final String PASSWORD = "ijunfu@163.com";

    @Test
    void digester() {

        Digester digester = new Digester();
        digester.setAlgorithm("SHA-256");
        byte[] digest = digester.digest(PASSWORD.getBytes(StandardCharsets.UTF_8));

        String encoded = Hex.encodeHexString(digest);
        System.out.println(encoded);
    }

    @Test
    void basicPasswordEncryptor() {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptPassword = passwordEncryptor.encryptPassword(PASSWORD);
        System.out.println(encryptPassword);

        boolean isSuccess = passwordEncryptor.checkPassword(PASSWORD, "RyglOcZCSJnz396GXU+/IQWacl5rWVJu");

        assertEquals(Boolean.TRUE, isSuccess);
    }

    @Test
    void configurablePasswordEncryptor() {
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm("SHA-256");
        passwordEncryptor.setPlainDigest(true);

        String encryptPassword = passwordEncryptor.encryptPassword(PASSWORD);
        System.out.println(encryptPassword);

        boolean isSuccess = passwordEncryptor.checkPassword(PASSWORD, "ZH5SLI2mLcPwhiO70Raw1rlKgHqzCGFaajwSOh5ld50=");

        assertEquals(Boolean.TRUE, isSuccess);
    }

    @Test
    void basicTextEncryptor() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("ZH5SLI2mLcPwhiO70Raw1rlKgHqzCGFaajwSOh5ld50=");

        String encrypted = textEncryptor.encrypt(PASSWORD);

        String decrypted = textEncryptor.decrypt(encrypted);

        assertEquals(PASSWORD, decrypted);
    }

    @Test
    void strongTextEncryptor() {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword("ZH5SLI2mLcPwhiO70Raw1rlKgHqzCGFaajwSOh5ld50=");

        String encrypted = textEncryptor.encrypt(PASSWORD);

        String decrypted = textEncryptor.decrypt(encrypted);

        assertEquals(PASSWORD, decrypted);
    }

    @Test
    void aES256TextEncryptor() {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("ZH5SLI2mLcPwhiO70Raw1rlKgHqzCGFaajwSOh5ld50=");

        String encrypted = textEncryptor.encrypt(PASSWORD);

        String decrypted = textEncryptor.decrypt(encrypted);

        assertEquals(PASSWORD, decrypted);
    }

    @Test
    void basicIntegerNumberEncryptor() {
        BasicIntegerNumberEncryptor numberEncryptor = new BasicIntegerNumberEncryptor();
        numberEncryptor.setPassword("ZH5SLI2mLcPwhiO70Raw1rlKgHqzCGFaajwSOh5ld50=");

        String bigNumber = "999999123456789";

        BigInteger encrypted = numberEncryptor.encrypt(new BigInteger(bigNumber));

        BigInteger decrypted = numberEncryptor.decrypt(encrypted);

        System.out.println(decrypted);

        assertEquals(bigNumber, decrypted.toString());
    }
}