package com.ijunfu;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.navigation.PdfExplicitDestination;
import com.itextpdf.kernel.pdf.navigation.PdfExplicitRemoteGoToDestination;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.DottedBorder;
import com.itextpdf.layout.borders.GrooveBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @Title  : iText 测试类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/5 16:41
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class PdfGithubTest {

    public static final String DIR = "E:/itext";

    @Test
    void intro() {
        try(Document doc = new Document(new PdfDocument(new PdfWriter(DIR + "/github_01_intro.pdf")))) {
            // 字体
            PdfFont pdfFont = PdfFontFactory.createFont(StandardFonts.COURIER);

            // 样式
            Style style = new Style()
                    .setFont(pdfFont)
                    .setFontSize(14)
                    .setFontColor(new DeviceRgb(83, 100, 83))
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY);

            Paragraph paragraph = new Paragraph()
                    .add("My name is ")
                    .add(new Text("ijunfu").addStyle(style))
                    .add(", I am ")
                    .add(new Text("18 years old").addStyle(style))
                    .add(" this year.");

            doc.add(paragraph);
        } catch (Exception e) {
            log.error("gen pdf error", e);
        }
    }

    @Test
    void genTable() {
        try(Document doc = new Document(new PdfDocument(new PdfWriter(DIR + "/github_02_table.pdf")))) {

            doc.add(new Paragraph("固定列宽"));

            // 固定列宽
            float[] widths = {10, 10, 80};
            Table table = new Table(widths);
//            table.setMarginTop(5);
            table.addHeaderCell("Col a");
            table.addHeaderCell("Col b");
            table.addHeaderCell("Col C");

            table.addCell("Value a");
            table.addCell("Value b");
            table.addCell("This is a long description for column c. " +
                    "It needs much more space hence we made sure that the third column is wider.");

            doc.add(table);

            doc.add(new Paragraph("自动列宽"));
            Table table2 = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
            table2.addHeaderCell("Col a");
            table2.addHeaderCell("Col b");

            table2.addCell("Value a");
            table2.addCell("Value b");

            table2.addCell(new Cell(1,2).add(new Paragraph("Value ab")));
            table2.addCell(new Cell(1, 2).add(new Paragraph("This is a long description for column c. " +
                    "It needs much more space hence we made sure that the third column is wider.")));
            doc.add(table2);
        } catch (Exception e) {
            log.error("gen pdf error", e);
        }
    }

    @Test
    void addImage() throws IOException {
        PdfWriter pdfWriter = new PdfWriter(DIR + "/github_03_image.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        ImageData imageData = ImageDataFactory.create(new ClassPathResource("images/fu.jpg").getFile().getPath());
        Image image = new Image(imageData);

        Document doc = new Document(pdfDocument, new PageSize(image.getImageWidth(), image.getImageHeight()));

        doc.add(image);
        doc.close();
    }

    @Test
    void addList() {
        try(Document doc = new Document(new PdfDocument(new PdfWriter(DIR + "/github_04_list.pdf")))) {

            List list = new List();
            list.add("Java");

            ListItem luaItem = new ListItem();
            luaItem.add(new Paragraph("Lua"));
            list.add(luaItem);

            List cList = new List();
            cList.add("C++");
            cList.add("C#");

            ListItem cItem = new ListItem();
            cItem.add(new Paragraph("C"));
            cItem.add(cList);
            list.add(cItem);

            doc.add(list);
        } catch (Exception e) {
            log.error("gen pdf error", e);
        }
    }

    @Test
    void addWatermarking() throws IOException {
        // step 4: 字体
        PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", PdfFontFactory.EmbeddingStrategy.FORCE_NOT_EMBEDDED);

        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(DIR + "/github_05_watermarking.pdf"));
        pdfDocument.addNewPage();
        pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new IEventHandler() {
            @Override
            public void handleEvent(Event event) {
                PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
                PdfDocument pdfDoc = docEvent.getDocument();
                PdfPage page = docEvent.getPage();

                PdfCanvas canvas = new PdfCanvas(page.newContentStreamAfter(), page.getResources(), pdfDoc);

                new Canvas(canvas, page.getPageSize())
                        .setFontColor(ColorConstants.LIGHT_GRAY)
                        .setFont(font)
                        .setFontSize(20)
                        .setOpacity(0.3f)
                        .showTextAligned(
                                new Paragraph("ijunfu<ijunfu@163.com>"),
                                298, 421,
                                pdfDoc.getPageNumber(page),
                                TextAlignment.CENTER,
                                VerticalAlignment.MIDDLE,
                                45
                        )
                        .close();
            }
        });
        Document doc = new Document(pdfDocument);

        // 样式
        Style style = new Style()
                .setFont(font)
                .setFontSize(14)
                .setFontColor(new DeviceRgb(83, 100, 83))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);

        Paragraph paragraph = new Paragraph()
                .add("My name is ")
                .add(new Text("ijunfu").addStyle(style))
                .add(", I am ")
                .add(new Text("18 years old").addStyle(style))
                .add(" this year.");
        doc.add(paragraph);

        Paragraph paragraph1 = new Paragraph().add("\n").add(new Text("水印").addStyle(style)).add("\n");
        doc.add(paragraph1);

        doc.add(new AreaBreak());



        doc.add(new Paragraph(new Text("固定列宽").addStyle(style)));

        // 固定列宽
        float[] widths = {10, 10, 80};
        Table table = new Table(widths);
//            table.setMarginTop(5);
        table.addHeaderCell("Col a");
        table.addHeaderCell("Col b");
        table.addHeaderCell("Col C");

        table.addCell("Value a");
        table.addCell("Value b");
        table.addCell("This is a long description for column c. " +
                "It needs much more space hence we made sure that the third column is wider.");

        doc.add(table);
        doc.add(new AreaBreak());

        doc.add(new Paragraph("自动列宽").addStyle(style));
        Table table2 = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        table2.addHeaderCell("Col a");
        table2.addHeaderCell("Col b");

        table2.addCell("Value a");
        table2.addCell("Value b");

        table2.addCell(new Cell(1,2).add(new Paragraph("Value ab")));
        table2.addCell(new Cell(1, 2).add(new Paragraph("This is a long description for column c. " +
                "It needs much more space hence we made sure that the third column is wider.")));
        doc.add(table2);
        doc.close();
    }

    @Test
    void addLink() throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(DIR + "/github_05_watermarking.pdf"), new PdfWriter(DIR + "/github_06_link.pdf"));

        try(Document doc = new Document(pdfDocument)) {

            // Make the link destination page fit to the display
            PdfExplicitDestination destination = PdfExplicitDestination.createFit(pdfDocument.getPage(3));
            Link link = new Link(
                    "This is a link. Click it and you'll be forwarded to another page in this document.",

                    // Add link to the 3rd page.
                    PdfAction.createGoTo(destination));

            // Set highlighting type which is enabled after a click on the annotation
            link.getLinkAnnotation().setHighlightMode(PdfAnnotation.HIGHLIGHT_INVERT);
            Paragraph p = new Paragraph(link).setWidth(240);
            doc.showTextAligned(p, 320, 695, 1, TextAlignment.LEFT,
                    VerticalAlignment.TOP, 0);

        } catch (Exception e) {
            log.error("gen pdf error", e);
        }
    }

}
