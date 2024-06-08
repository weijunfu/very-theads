package com.ijunfu.itext.chapter04;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/7 20:31
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _01TextAnno {

    public static void main(String[] args) throws IOException {
        genPdf();

        addTextAnno();
    }

    private static void addTextAnno() throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader("E:/itext/ebooks_41.textAnno1.pdf"),new PdfWriter("E:/itext/ebooks_41.textAnno2.pdf"));
        PageSize pageSize = PageSize.A4;
        Document document = new Document(pdfDocument, pageSize);

        document.add(new Paragraph("My name is ijunfu, and I am 16 years old this year."));

        PdfAnnotation textAnno = new PdfTextAnnotation(new Rectangle(20, 800, 0, 0))
                .setColor(new DeviceRgb(45, 108, 83))
                .setTitle(new PdfString("ijunfu"))
                .setContents("With ijunfu, "
                        + "you can truly take your documentation needs to the next level.");

        pdfDocument.getFirstPage().addAnnotation(textAnno);

        document.close();
    }

    private static void genPdf() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/ebooks_41.textAnno1.pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4);

        document.add(new Paragraph("My name is ijunfu, and I am 16 years old this year."));

        document.close();
    }
}
