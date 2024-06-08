package com.ijunfu.itext.chapter05;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 11:27
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _01ScaleImage {

    public static void main(String[] args) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter("E:/itext/ebooks_51.scaleImage.pdf"));

        Document document = new Document(pdfDocument);

        String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();
        ImageData imageData = ImageDataFactory.create(imagePath);

        // 正常图片
        document.add(new Image(imageData));

        // scaleToFit: 按固定长宽缩放图片
        document.add(new Image(imageData).scaleToFit(32, 32));

        // scale: 按比例缩放图片
        document.add(new Image(imageData).scale(0.5f, 0.5f));

        document.close();
    }

}
