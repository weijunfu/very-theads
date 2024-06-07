package com.ijunfu.itext.chapter02;

import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import java.io.FileNotFoundException;

/**
 *
 * title  : 绘制圆角按钮
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/7 17:17
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _05CanvasRoundRectangle {

    public static void main(String[] args) throws FileNotFoundException {

        PdfWriter pdfWriter = new PdfWriter("E:/itext/ebooks_25.canvasRoundRectangle.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        PageSize pageSize = PageSize.A4.rotate();

        PdfPage page = pdfDocument.addNewPage(pageSize);

        PdfCanvas canvas = new PdfCanvas(page);

        canvas.setStrokeColor(DeviceCmyk.CYAN)
                .setLineWidth(1)
                .roundRectangle(pageSize.getWidth()/2-100, pageSize.getHeight()/2-50, 200, 100, 50)
                .stroke();

        pdfDocument.close();
    }

}
