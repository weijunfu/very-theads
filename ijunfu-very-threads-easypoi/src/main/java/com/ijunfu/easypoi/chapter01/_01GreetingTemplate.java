package com.ijunfu.easypoi.chapter01;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @title  : 文本填充模板
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 10:10
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _01GreetingTemplate {

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();

        map.put("greeting", "Hi! My name is ijunfu.");

        XWPFDocument xwpfDocument = WordExportUtil.exportWord07("templates/greeting-template.docx", map);

        FileOutputStream outputStream = new FileOutputStream("E:/pdf/greeting.docx");

        xwpfDocument.write(outputStream);

        outputStream.flush();
        outputStream.close();

        xwpfDocument.close();
        System.out.println("Done!");
    }
}
