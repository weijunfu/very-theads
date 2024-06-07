package com.ijunfu.itext.chapter03;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;


/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/7 19:30
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _02EventHandler {

    public static final PdfFont font;

    static {
        try {
            font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfReader("E:/itext/ebooks_31.renderers.pdf"), new PdfWriter("E:/itext/ebooks_32.renderersEvent.pdf"));
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new MyEventHandler());
        pdf.close();
    }

    static class MyEventHandler implements IEventHandler {

        @Override
        public void handleEvent(Event event) {
            PdfDocumentEvent pdfDocumentEvent = (PdfDocumentEvent) event;
            PdfDocument pdfDocument = pdfDocumentEvent.getDocument();
            PdfPage page = pdfDocumentEvent.getPage();

            Document document = new Document(pdfDocument);

            int pageNumber = pdfDocument.getPageNumber(page);
            int totalPage = pdfDocument.getNumberOfPages();
            Rectangle pageSize = page.getPageSize();

            PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDocument);

            // Set background
            Color limeColor = new DeviceCmyk(0.208f, 0, 0.584f, 0);
            Color blueColor = new DeviceCmyk(0.445f, 0.0546f, 0, 0.0667f);

            pdfCanvas.saveState()
                    .setFillColor(pageNumber % 2 == 1 ? limeColor : blueColor)
                    .rectangle(pageSize.getLeft(), pageSize.getBottom(),
                            pageSize.getWidth(), pageSize.getHeight())
                    .fill().restoreState();
            //Add header and footer
            pdfCanvas.beginText()
                    .setFontAndSize(font, 9)
                    .moveText(pageSize.getWidth() / 2 - 60, pageSize.getTop() - 20)
                    .showText("THE TRUTH IS OUT THERE")
                    .moveText(60, -pageSize.getTop() + 30)
                    .showText(String.format("%d/%d", pageNumber, totalPage))
                    .endText();

            //Add watermark
            Style watermarkStyle = new Style()
                    .setFontColor(DeviceGray.GRAY)
                    .setFont(font)
                    .setFontSize(40)
                    .setBold()
                    .setOpacity(0.3f)
                    .setRotationAngle(Math.toRadians(45))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);

            document.add(
                    new Paragraph("ijunfu")
                            .setFixedPosition(pageSize.getWidth() / 6, pageSize.getHeight() / 8, 200)
                            .addStyle(watermarkStyle));

            document.add(
                    new Paragraph("ijunfu")
                            .setFixedPosition(pageSize.getWidth() / 6, pageSize.getHeight() / 2, 200)
                            .addStyle(watermarkStyle));

            document.add(
                    new Paragraph("ijunfu")
                            .setFixedPosition(pageSize.getWidth() / 2, pageSize.getHeight() / 2-100, 200)
                            .addStyle(watermarkStyle));


            document.add(
                    new Paragraph("ijunfu")
                            .setFixedPosition(pageSize.getWidth() - pageSize.getWidth() / 8, pageSize.getHeight() / 8, 200)
                            .addStyle(watermarkStyle));

            document.add(
                    new Paragraph("ijunfu")
                            .setFixedPosition(pageSize.getWidth() - pageSize.getWidth() / 8, pageSize.getHeight() / 2, 200)
                            .addStyle(watermarkStyle));

            pdfCanvas.release();
        }
    }
}
