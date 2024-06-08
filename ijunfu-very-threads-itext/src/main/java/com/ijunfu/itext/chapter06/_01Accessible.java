package com.ijunfu.itext.chapter06;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 *
 * title  : Creating accessible PDF documents
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 12:00
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _01Accessible {

    public static void main(String[] args) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(
                new PdfWriter(
                        "E:/itext/ebooks_61.access.pdf",
                        new WriterProperties().addXmpMetadata()
                )
        );

        pdfDocument.setTagged();
        pdfDocument.getCatalog().setLang(new PdfString("en-US"));
        pdfDocument.getCatalog().setViewerPreferences(
                new PdfViewerPreferences().setDisplayDocTitle(Boolean.TRUE)
        );

        // 设置PDF文档信息
        PdfDocumentInfo documentInfo = pdfDocument.getDocumentInfo();
        documentInfo.setTitle("Study Pdf (ijunfu)");
        documentInfo.setAuthor("ijunfu<ijunfu@163.com>");
        documentInfo.setCreator("ijunfu");
        documentInfo.setProducer("ijunfu tools");
        documentInfo.setKeywords("ijunfu,pdf,study");
        documentInfo.setSubject("ijunfu PDF Document");

        Document document = new Document(pdfDocument);

        PdfFont font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath());
        document.setFont(font);

        // 添加图片
        ImageData imageData = ImageDataFactory.create(new ClassPathResource("images/fu.jpg").getFile().getPath());
        document.add(new Image(imageData));

        // 添加文字，嵌入字体

        document.add(new Paragraph("Hi, My name is ijunfu. @2024 福").setFontSize(16).setFontColor(DeviceCmyk.CYAN));

        document.close();
    }
}
