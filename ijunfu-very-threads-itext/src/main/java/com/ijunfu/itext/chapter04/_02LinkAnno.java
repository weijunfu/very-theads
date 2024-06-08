package com.ijunfu.itext.chapter04;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/7 20:45
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _02LinkAnno {

    public static final PdfFont font;

    static {
        try {
            font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(
                new PdfWriter("E:/itext/ebooks_42.linkAnno.pdf")
        );

        PageSize pageSize = PageSize.A4;
        Document document = new Document(pdfDocument, pageSize);

        // Step 1: 点击文本，跳转到指定的链接
        Text text = new Text("weijunfu");
        text.setFont(font);
        text.setFontSize(16F);

        // Step 2: 设置提示内容
        text.getAccessibilityProperties().setAlternateDescription("Click here to go to the weijunfu website");

        // Step 3: 设置链接
        text.setAction(PdfAction.createURI("https://weijunfu.github.io"));

        // Step 4: 添加到文档
        Paragraph linkParagraph = new Paragraph(text).setUnderline();
        document.add(linkParagraph);

        document.close();
    }
}
