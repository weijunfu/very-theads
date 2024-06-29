package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @title  : 创建一个word文件
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 14:19
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */

public class _01CreateWord {

    public static void main(String[] args) throws IOException {
        // Step 1. Create a new Word document
        XWPFDocument doc = new XWPFDocument();

        // Step 2. Add a paragraph to the document
        XWPFParagraph paragraph = doc.createParagraph();
        paragraph.createRun().setText("Hello, World!");

        // Step 3. Write the document to a file
        FileOutputStream outputStream = new FileOutputStream("E:/pdf/01CreateWord.docx");
        doc.write(outputStream);

        // Step 4. Close the document
        outputStream.close();

        System.out.println("Done!");
    }
}
