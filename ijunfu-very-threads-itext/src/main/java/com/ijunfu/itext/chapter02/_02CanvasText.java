package com.ijunfu.itext.chapter02;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.AffineTransform;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/7 14:23
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _02CanvasText {

    public static void main(String[] args) throws IOException {

        PdfWriter pdfWriter = new PdfWriter("E:/itext/ebooks_22.canvasText.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        PageSize pageSize = PageSize.A4.rotate();   // A4 横向
        PdfPage page = pdfDocument.addNewPage(pageSize);

        PdfFont font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath(), PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);

        Vector<String> content = new Vector<>();
        content.add("江雪");
        content.add("唐·柳宗元");
        content.add("千山鸟飞绝，");
        content.add("万径人踪灭。");
        content.add("孤舟蓑笠翁，");
        content.add("独钓寒江雪。");

        PdfCanvas canvas = new PdfCanvas(page);
        // Draw the axes画出坐标系
        canvas.concatMatrix(1, 0, 0, 1, pageSize.getWidth() / 2, pageSize.getHeight() / 2);

        canvas.beginText().setFontAndSize(font, 14);
        for(int i=0; i<content.size(); i++) {
            canvas.setTextMatrix(0, -i*20);
            canvas.newlineShowText(content.elementAt(i));
        }
        canvas.endText();

        pdfDocument.close();
    }
}
