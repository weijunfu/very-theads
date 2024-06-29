package com.ijunfu.poi.chapter01;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @title  : 
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 19:41
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
class _10FillTemplateTest {

    @Test
    void matcher() {
        String input = "这里是{{示例内容1}}，那里是{{示例内容2}}，还有{{示例内容3}}。";
        String regex = "\\{\\{(.+?)\\}\\}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // 使用group(1)获取括号内的匹配内容，即{{和}}之间的字符
            System.out.println("匹配到的内容: " + matcher.group(1));
        }
    }

}