package com.ijunfu.itext.chapter02;

import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @Title  : 使用Canvas绘制十字直线
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/7 12:14
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _01CanvasLine {

    public static void main(String[] args) {
        try(PdfDocument pdfDoc = new PdfDocument(new PdfWriter("E:/itext/ebooks_21.canvasLine.pdf"))) {

            PageSize pageSize = PageSize.A4.rotate();
            PdfPage page = pdfDoc.addNewPage(pageSize);

            PdfCanvas canvas = new PdfCanvas(page);

            //Draw X axis
            canvas.moveTo(pageSize.getWidth()/6, pageSize.getHeight()/2)
                    .lineTo(pageSize.getWidth()-pageSize.getWidth()/6, pageSize.getHeight()/2)
                    .setColor(DeviceCmyk.CYAN, Boolean.TRUE)
                    .stroke()
                    .setLineWidth(0.5f);

            // Draw Y axis
            canvas.moveTo(pageSize.getWidth()/2, pageSize.getHeight()/6)
                    .lineTo(pageSize.getWidth()/2, pageSize.getHeight()-pageSize.getHeight()/6)
                    .setColor(DeviceCmyk.MAGENTA, Boolean.TRUE)
                    .stroke()
                    .setLineWidth(0.5f);
        } catch (Exception ex) {
            log.error("生成pdf文件失败", ex);
        }
    }
}
