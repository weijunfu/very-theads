package com.ijunfu.poi.chapter01;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @title  : 插入图片
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 18:22
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _06InsertImage {

    public static void main(String[] args) throws Exception {

        String file = _06InsertImage.class.getClassLoader().getResource("logo.png").getFile();

        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();

        FileInputStream inputStream = new FileInputStream(file);

        run.addPicture(
          inputStream, Document.PICTURE_TYPE_PNG, "logo.png", Units.toEMU(64), Units.toEMU(64)
        );

        // 保存文件
        FileOutputStream outputStream = new FileOutputStream("E:/pdf/06InsertImage.docx");
        doc.write(outputStream);

        outputStream.close();

        System.out.println("Done!");

    }
}
