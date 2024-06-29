package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Objects;

/**
 *
 * @title  : 文本填充模板
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 11:57
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _01GreetingTemplate {

    public static void main(String[] args) throws IOException {
        String file = _01GreetingTemplate.class.getClassLoader().getResource("templates/greeting-template.docx").getFile();

        XWPFDocument document = new XWPFDocument(new FileInputStream(file));

        String searchTest = "{{greeting}}";

        for(XWPFParagraph paragraph : document.getParagraphs()) {
            for(XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                if(Objects.nonNull(text) && text.contains(searchTest)) {
                    text = text.replace(searchTest, "Hello World!");
                    run.setText(text, 0);   // 0 表示先清空内容再填充文本
                }
            }
        }

        OutputStream outputStream = new FileOutputStream("E:/pdf/greetig2.docx");

        document.write(outputStream);

        outputStream.flush();
        outputStream.close();

        document.close();
    }
}
