package com.ijunfu.itext.chapter01;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;

/**
 *
 * @Title  : 创建第一个PDF文档
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/6 21:26
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _01HelloWorld {

    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: 输出器
        PdfWriter pdfWriter = new PdfWriter("E:/itext/ebooks_01.helloworld.pdf");

        // Step 2: 创建PDF文档
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        // Step 3: 创建文档
        Document document = new Document(pdfDocument);

        // Step 4: 向文档中添加内容
        document.add(new Paragraph("Hello World"));

        // Step 5: 关闭资源
        document.close();
    }

}
