package com.ijunfu.itext.chapter02;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * title  : 使用Canvas绘制矩形：正方形
 *
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/7 12:14
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _03CanvasRectangular {

    public static void main(String[] args) {
        try(PdfDocument pdfDoc = new PdfDocument(new PdfWriter("E:/itext/ebooks_23.canvasRectangular.pdf"))) {

            PageSize pageSize = PageSize.A4.rotate();
            PdfPage page = pdfDoc.addNewPage(pageSize);

            PdfCanvas canvas = new PdfCanvas(page);

            canvas.rectangle(pageSize.getWidth()/2-50, pageSize.getHeight()/2-50, 100, 100)
                    .stroke();


        } catch (Exception ex) {
            log.error("生成pdf文件失败", ex);
        }
    }
}
