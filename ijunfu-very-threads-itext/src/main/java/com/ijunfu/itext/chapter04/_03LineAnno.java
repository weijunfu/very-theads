package com.ijunfu.itext.chapter04;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfLineAnnotation;
import java.io.FileNotFoundException;

/**
 *
 * title  : line annotation
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 9:25
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _03LineAnno {

    public static void main(String[] args) throws FileNotFoundException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("E:/itext/ebooks_43.lineAnno.pdf"));

        PdfPage page = pdf.addNewPage();

        PdfArray lineEndings = new PdfArray();
        lineEndings.add(new PdfName("Diamond"));
        lineEndings.add(new PdfName("Diamond"));

        //Create line annotation with inside caption
        PdfAnnotation annotation = new PdfLineAnnotation(
                new Rectangle(0, 0),
                new float[]{20, 790, page.getPageSize().getWidth() - 20, 790})
                .setLineEndingStyles((lineEndings))
                .setContentsAsCaption(true)
                .setTitle(new PdfString("iText"))
                .setContents("The example of line annotation")
                .setColor(ColorConstants.BLUE);
        page.addAnnotation(annotation);

        //Close document
        pdf.close();

        //TODO 上述代码未生效，待继续研究
    }

}
