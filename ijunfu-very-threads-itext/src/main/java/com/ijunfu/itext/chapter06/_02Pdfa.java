package com.ijunfu.itext.chapter06;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfAConformanceLevel;
import com.itextpdf.kernel.pdf.PdfOutputIntent;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.pdfa.PdfADocument;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 16:07
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _02Pdfa {

    public static void main(String[] args) throws IOException {
        PdfADocument pdfDoc = new PdfADocument(
                new PdfWriter("E:/itext/ebooks_62.pdfa.pdf"),
                PdfAConformanceLevel.PDF_A_1B,
                new PdfOutputIntent(
                        "ijunfu",
                        "",
                        "http://www.color.org",
                        "sRGB IEC61966-2.1",
                        new FileInputStream(new ClassPathResource("icc/sRGB_v4_ICC_preference.icc").getFile().getPath())
                )
        );

        pdfDoc.setTagged();

        Document doc = new Document(pdfDoc);

        PdfFont font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath());
        doc.setFont(font);

        // 添加图片
        ImageData imageData = ImageDataFactory.create(new ClassPathResource("images/fu.jpg").getFile().getPath());
        doc.add(new Image(imageData));

        // 添加文字，嵌入字体
        doc.add(new Paragraph("Hi, My name is ijunfu. @2024 福").setFontSize(16).setFontColor(DeviceRgb.BLUE));

        doc.close();
    }
}
