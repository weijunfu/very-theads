package com.ijunfu.jasypt;

import org.apache.commons.codec.binary.Hex;
import org.jasypt.util.digest.Digester;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import java.nio.charset.StandardCharsets;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/9 20:02
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class JasyptDemo {

    public static void main(String[] args) {

        String author = "ijunfu";
        System.out.println(author);

        Digester digester = new Digester();
        digester.setAlgorithm("SHA-256");
        byte[] digest = digester.digest(author.getBytes(StandardCharsets.UTF_8));

        String encoded = Hex.encodeHexString(digest);
        System.out.println(encoded);    // 93c7bcc5c58bb5142cba7fd9a51e1dcf8b4e396e3dc0bafdecd3166cc180cd1c

        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptPassword = passwordEncryptor.encryptPassword(author);
        System.out.println(encryptPassword);

        boolean isSuccess = passwordEncryptor.checkPassword(author, "ZDwYdYvieTJAszba8/D9sAm+XUrqulc8");

        System.out.println(isSuccess);

        ConfigurablePasswordEncryptor configurablePasswordEncryptor = new ConfigurablePasswordEncryptor();
        configurablePasswordEncryptor.setAlgorithm("SHA-256");
        configurablePasswordEncryptor.setPlainDigest(true);

        encryptPassword = configurablePasswordEncryptor.encryptPassword(author);
        System.out.println(encryptPassword);

        isSuccess = configurablePasswordEncryptor.checkPassword(author, "k8e8xcWLtRQsun/ZpR4dz4tOOW49wLr97NMWbMGAzRw=");
        System.out.println(isSuccess);
    }

}
