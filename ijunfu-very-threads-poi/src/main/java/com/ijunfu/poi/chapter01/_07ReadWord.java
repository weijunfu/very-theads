package com.ijunfu.poi.chapter01;

import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @title  : 读取word
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 18:31
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _07ReadWord {

    public static void main(String[] args) throws Exception {
        String file = "E:/pdf/03AddArticle.docx";
        FileInputStream fis = new FileInputStream(file);

        XWPFDocument doc = new XWPFDocument(fis);

        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(doc);

        String text = wordExtractor.getText();
        System.out.println(text);

        POIXMLProperties.CoreProperties properties = wordExtractor.getCoreProperties();
        String category = properties.getCategory();
        System.out.println(String.format("分类：%s", category));

        String title = properties.getTitle();
        System.out.println(String.format("标题：%s", title));

        String creator = properties.getCreator();
        System.out.println(String.format("创建人：%s", creator));

        Date created = properties.getCreated();
        System.out.println(String.format("创建时间：%s", created));

        fis.close();
    }
}
