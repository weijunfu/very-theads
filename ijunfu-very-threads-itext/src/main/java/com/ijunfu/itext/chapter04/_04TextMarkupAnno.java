package com.ijunfu.itext.chapter04;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextMarkupAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.FileNotFoundException;

/**
 *
 * title  : popop 注释
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 9:25
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _04TextMarkupAnno {

    public static void main(String[] args) throws FileNotFoundException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter("E:/itext/ebooks_44.textMarkupAnno.pdf"));

        //Initialize document
        Document document = new Document(pdfDoc);

        Paragraph p = new Paragraph("The example of text markup annotation.");
        document.showTextAligned(p, 20, 795, 1, TextAlignment.LEFT,
                VerticalAlignment.MIDDLE, 0);

        //Create text markup annotation
        PdfAnnotation ann = PdfTextMarkupAnnotation.createHighLight(new Rectangle(105, 790, 64, 10),
                        new float[]{169, 790, 105, 790, 169, 800, 105, 800})
                .setColor(ColorConstants.YELLOW)
                .setContents(new PdfString("I'm a popup."))
                .setTitle(new PdfString("iText"))
                .setRectangle(new PdfArray(new float[]{100, 600, 200, 100}));
        pdfDoc.getFirstPage().addAnnotation(ann);

        //Close document
        document.close();

    }

}
