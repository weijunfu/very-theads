package com.ijunfu;

import com.itextpdf.commons.utils.JsonUtil;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.kernel.pdf.canvas.parser.EventType;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData;
import com.itextpdf.kernel.pdf.canvas.parser.listener.IEventListener;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.DottedBorder;
import com.itextpdf.layout.borders.GrooveBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

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
public class PdfTest {

    @Test
    void helloWorld() throws FileNotFoundException {

        // step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/01_hello.pdf");

        // step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();   // 新增一个页面

        // step 3: 创建Document
        Document document = new Document(pdfDocument);

        // step 4: 创建Paragraph
        Paragraph paragraph = new Paragraph("Hello, World!");
        document.add(paragraph);

        // step 5: 关闭Document
        document.close();
    }

    @Test
    void readHello() throws IOException {
        PdfReader pdfReader = new PdfReader("E:/itext/01_hello.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfReader);

        for(int page=1; page<=pdfDocument.getNumberOfPages(); page++) {
            String text = PdfTextExtractor.getTextFromPage(pdfDocument.getPage(page));
            log.info("Page {}: {}", page, text);
        }

        pdfDocument.close();
    }

    @Test
    void imagePath() throws IOException {
        String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();
        log.info("{}", imagePath);
    }

    @Test
    void addImage() throws IOException {

        // step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/02_image.pdf");

        // step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();   // 新增一个页面

        // step 3: 创建Document
        Document document = new Document(pdfDocument);

        // step 4: 添加图片
        String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();
        ImageData imageData = ImageDataFactory.create(imagePath);
        Image image = new Image(imageData);
        document.add(image);

        // step 5: 关闭Document
        document.close();
    }

    @Test
    void addList() throws FileNotFoundException {

        // step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/03_list.pdf");

        // step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();   // 新增一个页面

        // step 3: 创建Document
        Document document = new Document(pdfDocument);

        // step 4: 添加列表
        List languages = new List();
        languages.add("Java");
        languages.add("C");
        languages.add("Go");
        languages.add("Python");
        document.add(languages);

        // step 5: 关闭Document
        document.close();
    }

    @Test
    void addFont() throws IOException {
        // step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/04_font.pdf");

        // step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();   // 新增一个页面

        // step 3: 创建Document
        Document document = new Document(pdfDocument);

        // step 4: 字体
        PdfFont courierFont = PdfFontFactory.createFont(StandardFonts.COURIER);
        PdfFont courierBoldFont = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);

        String content = "ijunfu<ijunfu@163.com>";
        Text courierText = new Text(content).setFont(courierFont);
        Text courierBoldText = new Text(content).setFont(courierBoldFont);

        Paragraph courierParagraph = new Paragraph()
                .add(courierText);
        Paragraph courierBoldParagraph = new Paragraph()
                .add(courierBoldText);

        document.add(courierParagraph);
        document.add(courierBoldParagraph);

        // step 5: 关闭Document
        document.close();
    }

    @Test
    void embedFonts() throws IOException {
        // step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/05_embed_fonts.pdf");

        // step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();   // 新增一个页面

        // step 3: 创建Document
        Document document = new Document(pdfDocument);

        // step 4: 字体
        String jetBrainsMonoRegular = new ClassPathResource("fonts/JetBrainsMono-Regular.woff2").getPath();

        PdfFont courierFont = PdfFontFactory.createFont(jetBrainsMonoRegular, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);

        String content = "ijunfu<ijunfu@163.com>";
        Text courierText = new Text(content).setFont(courierFont);

        Paragraph courierParagraph = new Paragraph()
                .add(courierText);

        document.add(courierParagraph);

        // step 5: 关闭Document
        document.close();
    }

    @Test
    void fontStyle() throws IOException {
        // step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/06_font-style.pdf");

        // step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();   // 新增一个页面

        // step 3: 创建Document
        Document document = new Document(pdfDocument);

        // step 4: 字体
        String jetBrainsMonoRegular = new ClassPathResource("fonts/JetBrainsMono-Regular.woff2").getPath();

        PdfFont font = PdfFontFactory.createFont(jetBrainsMonoRegular, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);

        String content = "ijunfu<ijunfu@163.com>";
        Text boldText = new Text(content).setFont(font).setBold();                                         // 粗体
        Text italicText = new Text(content).setFont(font).setItalic();                                     // 斜体
        Text underlineText = new Text(content).setFont(font).setUnderline();                               // 下划线
        Text fontSizeText = new Text(content).setFont(font).setFontSize(16f);                              // 字体大小
        Text fontColorText = new Text(content).setFont(font).setFontColor(DeviceRgb.BLUE);                 // 字体颜色
        Text backgroundColorText = new Text(content).setFont(font).setBackgroundColor(DeviceRgb.GREEN);    // 背景颜色
        Text strokeColorText = new Text(content)
                .setFont(font)
                .setBold()
                .setStrokeColor(DeviceCmyk.CYAN);

        Text strokeColorText2 = new Text(content)
                .setFont(font)
                .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE)
                .setStrokeColor(DeviceCmyk.CYAN)
                .setStrokeWidth(0.5f);

        Paragraph boldParagraph = new Paragraph()
                .add(boldText);
        Paragraph italicParagraph = new Paragraph()
                .add(italicText);
        Paragraph underlineParagraph = new Paragraph()
                .add(fontSizeText);
        Paragraph fontSizeParagraph = new Paragraph()
                .add(underlineText);
        Paragraph fontColorParagraph = new Paragraph()
                .add(fontColorText);
        Paragraph backgroundColorParagraph = new Paragraph()
                .add(backgroundColorText);
        Paragraph strokeColorParagraph = new Paragraph()
                .add(strokeColorText);
        Paragraph strokeColorParagraph2 = new Paragraph()
                .add(strokeColorText2);

        document.add(boldParagraph)
                .add(italicParagraph)
                .add(underlineParagraph)
                .add(fontSizeParagraph)
                .add(fontColorParagraph)
                .add(backgroundColorParagraph)
                .add(strokeColorParagraph)
                .add(strokeColorParagraph2);

        // step 5: 关闭Document
        document.close();

    }

    @Test
    void useStyle() throws FileNotFoundException {
        // Step 1: 创建PdfWriter，文件目录必须存在
        PdfWriter pdfWriter = new PdfWriter("E:/itext/07_use_style.pdf");

        // Step 2: 创建PdfDocument
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        Style author = new Style();
        author.setFontColor(DeviceCmyk.MAGENTA)
                .setFontSize(12f)
                .setBold()
                .setItalic();

        Paragraph paragraph = new Paragraph("ijunfu<ijunfu@163.com>").addStyle(author);
        document.add(paragraph);

        document.close();
    }

    @Test
    void createTable() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/08_create_table.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        float[] columnWidths = { 200f, 50f, 100f };
        Table table = new Table(columnWidths);

        table.addCell(new Cell().add(new Paragraph("Item")));
        table.addCell(new Cell().add(new Paragraph("Qty")));
        table.addCell(new Cell().add(new Paragraph("Available")));

        table.addCell(new Cell().add(new Paragraph("Mango")));
        table.addCell(new Cell().add(new Paragraph("2 Kg")));
        table.addCell(new Cell().add(new Paragraph("Yes")));

        table.addCell(new Cell().add(new Paragraph("Orange")));
        table.addCell(new Cell().add(new Paragraph("5 Kg")));
        table.addCell(new Cell().add(new Paragraph("No")));

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void useArrayCreateTable() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/09_create_table_use_array.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        String[] tableHeader = {"Item", "Color", "Size"};

        String[][] items = {
                {"Box", "Red", "Big"},
                {"Bat", "White", "Big"},
                {"Stick", "Black", "Long"},
                {"Ball", "Gray", "Small"}
        };

        float[] columnWidths = { 200f, 50f, 100f };
        Table table = new Table(columnWidths);

        for(int i=0; i< tableHeader.length; i++) {
            table.addCell(new Cell().add(new Paragraph(tableHeader[i])));
        }

        for(int i=0; i<items.length;i++) {

            for(int j=0; j<items[i].length; j++) {
                table.addCell(new Cell().add(new Paragraph(items[i][j])));
            }

        }

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void useArrayCreateTable_fillColor() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/09_create_table_use_array_fill_color.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        String[] tableHeader = {"Item", "Color", "Size"};

        String[][] items = {
                {"Box", "Red", "Big"},
                {"Bat", "White", "Big"},
                {"Stick", "Black", "Long"},
                {"Ball", "Gray", "Small"}
        };

        float[] columnWidths = { 200f, 50f, 100f };
        Table table = new Table(columnWidths);

        for(int i=0; i< tableHeader.length; i++) {
            table.addCell(
                    new Cell().add(
                            new Paragraph(tableHeader[i])
                                    .setTextAlignment(TextAlignment.CENTER)
                                    .setBold()
                                    .setBackgroundColor(DeviceGray.GRAY)
                    )
            );
        }

        for(int i=0; i<items.length;i++) {

            for(int j=0; j<items[i].length; j++) {
                if(i%2==0) {
                    table.addCell(new Cell().add(new Paragraph(items[i][j]).setBackgroundColor(new DeviceCmyk(0, 0, 0, 10))));
                } else {
                    table.addCell(new Cell().add(new Paragraph(items[i][j]).setBackgroundColor(DeviceCmyk.CYAN)));
                }

            }

        }

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void createTable_border() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/10_create_table_border.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        String[] tableHeader = {"Item", "Color", "Size"};

        String[][] items = {
                {"Box", "Red", "Big"},
                {"Bat", "White", "Big"},
                {"Stick", "Black", "Long"},
                {"Ball", "Gray", "Small"}
        };

        float[] columnWidths = { 200f, 50f, 100f };
        Table table = new Table(columnWidths);

        for(int i=0; i< tableHeader.length; i++) {
            table.addCell(
                    new Cell().add(
                            new Paragraph(tableHeader[i])
                                    .setTextAlignment(TextAlignment.CENTER)
                                    .setBold()
                                    .setBackgroundColor(DeviceGray.GRAY)
                    ).setBorder(new GrooveBorder(new DeviceRgb(100, 100, 100), 0.5f))
            );
        }

        for(int i=0; i<items.length;i++) {

            for(int j=0; j<items[i].length; j++) {
                if(i%2==0) {
                    table.addCell(new Cell().add(new Paragraph(items[i][j]).setBackgroundColor(new DeviceCmyk(0, 0, 0, 10)))
                            .setBorder(new DashedBorder(DeviceCmyk.CYAN, 0.5f)));
                } else {
                    table.addCell(new Cell().add(new Paragraph(items[i][j]).setBackgroundColor(DeviceCmyk.MAGENTA))
                            .setBorder(new DottedBorder(DeviceRgb.BLUE, 0.5f)));
                }

            }

        }

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void createTable_addImage() throws IOException {

        PdfWriter pdfWriter = new PdfWriter("E:/itext/11_create_table_image.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        float[] columnWidths = { 200f, 100f};

        Table table = new Table(columnWidths);

        String[] tableHeaders = { "Logo", "Name" };
        for(int i=0; i<tableHeaders.length; i++) {
            table.addCell(new Cell().add(new Paragraph(tableHeaders[i])));
        }

        // step 4: 添加图片
        String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();
        ImageData imageData = ImageDataFactory.create(imagePath);
        Image image = new Image(imageData);

        table.addCell(new Cell().add(image));
        table.addCell(new Cell().add(new Paragraph("ijunfu")));

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void createTable_nested() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/12_create_table_nested.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        float[] columnWidths = { 50f, 100f, 200f };
        Table table = new Table(columnWidths);

        String[] headers = { "No.", "Paren", "Child" };

        for(int i=0; i<headers.length; i++) {
            table.addCell(new Cell().add(new Paragraph(headers[i])));
        }

        table.addCell(new Cell().add(new Paragraph("1")));
        table.addCell(new Cell().add(new Paragraph("Animal")));

        float[] columnWidth2 = { 50f, 100f };
        String[] headers2 = { "No.", "Name" };
        Table table2 = new Table(columnWidth2);
        for(int i=0; i<headers2.length; i++) {
            table2.addCell(new Cell().add(new Paragraph(headers2[i])));
        }

        String[][] datas = {
                { "1", "Cat"},
                { "2", "Dog"},
                { "3", "Trigger"}
        };

        for(int i=0; i<datas.length; i++) {

            for(int j=0; j<datas[i].length; j++) {
                table2.addCell(new Cell().add(new Paragraph(datas[i][j])));
            }

        }

        table.addCell(new Cell().add(table2));

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void createTable_list() throws FileNotFoundException {

        PdfWriter pdfWriter = new PdfWriter("E:/itext/13_create_table_list.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        float[] columnWidths = { 50f, 100f, 200f };
        String[] headers = { "No.", "Type", "Value" };

        Table table = new Table(columnWidths);

        for(int i=0; i<headers.length; i++) {
            table.addCell(new Cell().add(new Paragraph(headers[i])).setTextAlignment(TextAlignment.CENTER).setBold());
        }

        table.addCell(new Cell().add(new Paragraph("1")).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add(new Paragraph("Color").setTextAlignment(TextAlignment.CENTER)));

        List colors = new List();
        colors.add("Red");
        colors.add("Green");
        colors.add("Yellow");
        table.addCell(new Cell().add(colors));


        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void tableSpan() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/14_create_table_span.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        float[] columnWidths = { 100f, 100f, 100f };
        Table table = new Table(columnWidths);

        table.addCell(new Cell().add(new Paragraph("1")));
        table.addCell(new Cell().add(new Paragraph("2")));
        table.addCell(new Cell(2, 0).add(new Paragraph("3")));
        table.addCell(new Cell().add(new Paragraph("4")));
        table.addCell(new Cell().add(new Paragraph("5")));
        table.addCell(new Cell(0, 2).add(new Paragraph("6")));
        table.addCell(new Cell().add(new Paragraph("7")));

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void complexTable() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/15_create_table_complex.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        float[] columnWidths = { 50f, 50f, 50f, 50f, 50f, 50f };
        Table table = new Table(columnWidths);

        table.setTextAlignment(TextAlignment.CENTER);   // 水平居中

        table.addCell(new Cell().add(new Paragraph("1")));
        table.addCell(new Cell(2, 0).add(new Paragraph("2")));
        table.addCell(new Cell(3, 0).add(new Paragraph("3")));
        table.addCell(new Cell(3, 0).add(new Paragraph("4")));
        table.addCell(new Cell(0, 2).add(new Paragraph("5")));
        table.addCell(new Cell().add(new Paragraph("6")));
        table.addCell(new Cell().add(new Paragraph("7")));
        table.addCell(new Cell().add(new Paragraph("8")));
        table.addCell(new Cell().add(new Paragraph("9")));
        table.addCell(new Cell().add(new Paragraph("10")));
        table.addCell(new Cell().add(new Paragraph("11")));
        table.addCell(new Cell().add(new Paragraph("12")));

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

    @Test
    void listSymbol_text() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/16_list_symbol_text.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        List languages = new List();
        languages.add("Java");
        languages.add("C");
        languages.add("Python");
        languages.add("PHP");
        languages.add("Go");
        languages.add("Lua");
        languages.add("Rust");

        languages.setListSymbol(new Text("\u00BB"));

        Document document = new Document(pdfDocument);
        document.add(languages);
        document.close();
    }

    @Test
    void listSymbol_font() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/17_list_symbol_font.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        List languages = new List();
        languages.add("Java");
        languages.add("C");
        languages.add("Python");
        languages.add("PHP");
        languages.add("Go");
        languages.add("Lua");
        languages.add("Rust");

        PdfFont pdfFont = PdfFontFactory.createFont(new ClassPathResource("fonts/Zapf-Dingbats-BT.ttf").getPath(), PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);
        languages.setListSymbol(new Text("c ").setFont(pdfFont));

        Document document = new Document(pdfDocument);
        document.add(languages);
        document.close();
    }

    @Test
    void listSymbol_image() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/18_list_symbol_image.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        List languages = new List();
        languages.setFontSize(20f);
        languages.add("Java");
        languages.add("C");
        languages.add("Python");
        languages.add("PHP");
        languages.add("Go");
        languages.add("Lua");
        languages.add("Rust");

        String imagePath = new ClassPathResource("images/snow.png").getFile().getPath();
        ImageData imageData = ImageDataFactory.create(imagePath);
        imageData.setHeight(15f);
        imageData.setWidth(15f);

        Image image = new Image(imageData);
        languages.setListSymbol(image);

        Document document = new Document(pdfDocument);
        document.add(languages);
        document.close();
    }

    @Test
    void customPageSize() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/19_page_size-custom.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Rectangle pageSize = new Rectangle(400, 300);
        pdfDocument.setDefaultPageSize(new PageSize(pageSize));

        Document document = new Document(pdfDocument, pdfDocument.getDefaultPageSize());
        document.add(new Paragraph("ijunfu<ijunfu@163.com>"));
        document.close();
    }

    @Test
    void customPageSize2() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/20_page_size-default.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());

        Document document = new Document(pdfDocument, pdfDocument.getDefaultPageSize());
        document.add(new Paragraph("ijunfu<ijunfu@163.com>"));
        document.close();
    }

    @Test
    void genInvoice() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/21_invoice.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        DeviceRgb themeColor = new DeviceRgb(63, 169, 219);

        float columnWidth = 280f;
        float[] columnWidths = { columnWidth, columnWidth };

        Table table = new Table(columnWidths);
        table.setBackgroundColor(themeColor)
                .setFontColor(DeviceRgb.WHITE);

        table.addCell(
                new Cell().add(new Paragraph("INVOICE"))
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setPaddingTop(30f)
                        .setPaddingBottom(30f)
                        .setBorder(Border.NO_BORDER)
                        .setFontSize(30f)
        );
        table.addCell(
                new Cell().add(new Paragraph("ijunfu Technology\n#7129 ijunfu\n9876543210"))
                        .setTextAlignment(TextAlignment.RIGHT)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setPaddingTop(30f)
                        .setPaddingBottom(30f)
                        .setBorder(Border.NO_BORDER)
                        .setPaddingRight(10f)
        );

        float[] customInfoColumnWidths = { 80, 300, 100, 100 };
        Table customInfoTable = new Table(customInfoColumnWidths);

        customInfoTable.addCell(
          new Cell(0, 4).add(new Paragraph("Customer Information")).setBold()
                  .setBorder(Border.NO_BORDER)
                  .setFontSize(16f)
        );

        customInfoTable.addCell(
                new Cell().add(new Paragraph("Name"))
                        .setBorder(Border.NO_BORDER)
                        .setBold()
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("ijunfu"))
                        .setBorder(Border.NO_BORDER)
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("Invoice No."))
                        .setBorder(Border.NO_BORDER)
                        .setBold()
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("7219"))
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.RIGHT)
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("Mo. No."))
                        .setBorder(Border.NO_BORDER)
                        .setBold()
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("738827362392983"))
                        .setBorder(Border.NO_BORDER)
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("Date"))
                        .setBorder(Border.NO_BORDER)
                        .setBold()
        );
        customInfoTable.addCell(
                new Cell().add(new Paragraph("2024-06-06"))
                        .setBorder(Border.NO_BORDER)
                        .setTextAlignment(TextAlignment.RIGHT)
        );

        float[] itemInfoColumnWidths = { 140, 140, 140, 140 };
        Table itemInfoTable =  new Table(itemInfoColumnWidths);

        String[] itemInfoHeaders = { "Service", "Hrs.", "Unit Price(RMB)", "Amount" };
        for(int i=0; i<itemInfoHeaders.length; i++) {
            itemInfoTable.addCell(
              new Cell().add(new Paragraph(itemInfoHeaders[i]))
                      .setTextAlignment(TextAlignment.CENTER)
                      .setBold()
                      .setBackgroundColor(themeColor)
                      .setFontColor(DeviceRgb.WHITE)
            );
        }

        String[][] itemInfos = {
                { "App Creation", "20", "200",  "" +20*200 },
                { "Website Design", "15", "150",  "" +15*150}
        };

        for(int i=0; i<itemInfos.length; i++) {
            for(int j=0; j<itemInfos[i].length; j++) {

                if(j == 0) {
                    itemInfoTable.addCell(
                            new Cell().add(new Paragraph(itemInfos[i][j]))
                    );
                } else {
                    itemInfoTable.addCell(
                            new Cell().add(new Paragraph(itemInfos[i][j]))
                                    .setTextAlignment(TextAlignment.RIGHT)
                    );
                }

            }
        }

        String[] totalInfo = {
                "Total", "" + (20 + 15), "" + (200 + 150), "" + (20 * 200 + 15 * 150)
        };
        for(int i=0; i<totalInfo.length; i++) {
            if(i == 0) {
                itemInfoTable.addCell(
                        new Cell().add(new Paragraph(totalInfo[i]))
                                .setBackgroundColor(themeColor)
                                .setFontColor(DeviceRgb.WHITE)
                                .setTextAlignment(TextAlignment.CENTER)
                );
            } else {
                itemInfoTable.addCell(
                        new Cell().add(new Paragraph(totalInfo[i]))
                                .setTextAlignment(TextAlignment.RIGHT)
                                .setBackgroundColor(themeColor)
                                .setFontColor(DeviceRgb.WHITE)
                );
            }
        }

        // step 4: 字体
        String jetBrainsMonoRegular = new ClassPathResource("fonts/JetBrainsMono-Regular.woff2").getPath();
        PdfFont font = PdfFontFactory.createFont(jetBrainsMonoRegular, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);

        Document document = new Document(pdfDocument);
        document.setFont(font);
        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(customInfoTable);
        document.add(new Paragraph("\n"));
        document.add(itemInfoTable);
        document.add(new Paragraph("\n(Authorised ijunfu)").setTextAlignment(TextAlignment.RIGHT));
        document.close();
    }


    @Test
    void waterText() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/22_water_text.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        String waterContent = "ijunfu<ijunfu@163.com>";
        document.add(new Paragraph(waterContent)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(100f, pdfDocument.getDefaultPageSize().getHeight()/2, 200f));
        document.add(new Paragraph(waterContent)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/2, pdfDocument.getDefaultPageSize().getHeight()/2, 200f));
        document.add(new Paragraph(waterContent)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/2+200, pdfDocument.getDefaultPageSize().getHeight()/2, 200f));

        document.add(new Paragraph("Happiness is a journey\n" +
                "\n" +
                "We always convince ourselves that life will be better after we get married, have a baby, then another. Then we are frustrated that the kids aren't old enough and we'll be more content when they are. After that we' re frustrated that we have teenagers to deal with. We will certainly be happy when they are out of that stage.\n" +
                "\n" +
                "We always tell ourselves that our life will be complete when our spouse gets his or her act together, when we get a nicer car, and are able to go on a nice vacation, when we retire. The truth is, there's no better time than right now. If not now, when? Our life will always be filled with challenges. It's best to admit this to ourselves and decide to be happy anyway.\n" +
                "\n" +
                "One of my favorite quotes comes from Alfred Souza. He said, \"For a long time it had seemed to me that life was about to begin-real life. But there was always some obstacle in the way, something to be gotten through first, some unfinished business, time still to be served, a debt to be paid. Then life would begin. At last it dawned onto me that these obstacles were my life. \"\n" +
                "\n" +
                "This perspective has helped me to see that there is no way to happiness. Happiness is the way. So treasure every moment that you have. And remember that time waits for no one. So stop waiting until you finish school, until you go back to school; until you get married, until you get divorced; until you have kids, until your kids leave home; until you start work, until you retire; until you get a new car or home; until spring; until you are born again to decide that there is no better time than right now to be happy....\n" +
                "\n" +
                "Happiness is a journey, not a destination. So, Work like you don't need money, Love like you've never been hurt, And dance like no one's watching."));

        document.close();
    }

    @Test
    void waterImage() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/22_water_image.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();
        ImageData imageData = ImageDataFactory.create(imagePath);

        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(10f, pdfDocument.getDefaultPageSize().getHeight()/2, 200f));
        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/3, pdfDocument.getDefaultPageSize().getHeight()/2, 200f));
        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/3+200, pdfDocument.getDefaultPageSize().getHeight()/2, 200f));

        document.add(new Paragraph("Happiness is a journey\n" +
                "\n" +
                "We always convince ourselves that life will be better after we get married, have a baby, then another. Then we are frustrated that the kids aren't old enough and we'll be more content when they are. After that we' re frustrated that we have teenagers to deal with. We will certainly be happy when they are out of that stage.\n" +
                "\n" +
                "We always tell ourselves that our life will be complete when our spouse gets his or her act together, when we get a nicer car, and are able to go on a nice vacation, when we retire. The truth is, there's no better time than right now. If not now, when? Our life will always be filled with challenges. It's best to admit this to ourselves and decide to be happy anyway.\n" +
                "\n" +
                "One of my favorite quotes comes from Alfred Souza. He said, \"For a long time it had seemed to me that life was about to begin-real life. But there was always some obstacle in the way, something to be gotten through first, some unfinished business, time still to be served, a debt to be paid. Then life would begin. At last it dawned onto me that these obstacles were my life. \"\n" +
                "\n" +
                "This perspective has helped me to see that there is no way to happiness. Happiness is the way. So treasure every moment that you have. And remember that time waits for no one. So stop waiting until you finish school, until you go back to school; until you get married, until you get divorced; until you have kids, until your kids leave home; until you start work, until you retire; until you get a new car or home; until spring; until you are born again to decide that there is no better time than right now to be happy....\n" +
                "\n" +
                "Happiness is a journey, not a destination. So, Work like you don't need money, Love like you've never been hurt, And dance like no one's watching."));

        document.close();
    }

    @Test
    void pageHeaderAndFooter() throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/23_page_header_footer.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);

        String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();
        ImageData imageData = ImageDataFactory.create(imagePath);

        document.add(new Image(imageData)
                        .setFontColor(new DeviceRgb(100, 100, 100))
                        .setFixedPosition(10f, pdfDocument.getDefaultPageSize().getHeight() - 40f, 40)
                        .setOpacity(1f)
        );

        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()-40, 10f, 40)
                .setOpacity(1f)
        );

        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(10f, pdfDocument.getDefaultPageSize().getHeight()/2, 100f));
        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/3, pdfDocument.getDefaultPageSize().getHeight()/2, 100f));
        document.add(new Image(imageData)
                .setFontColor(new DeviceRgb(100, 100, 100))
                .setOpacity(0.3f)
                .setRotationAngle(0.5f)
                .setFixedPosition(pdfDocument.getDefaultPageSize().getWidth()/3+200, pdfDocument.getDefaultPageSize().getHeight()/2, 100f));

        document.add(new Paragraph("Happiness is a journey\n" +
                "\n" +
                "We always convince ourselves that life will be better after we get married, have a baby, then another. Then we are frustrated that the kids aren't old enough and we'll be more content when they are. After that we' re frustrated that we have teenagers to deal with. We will certainly be happy when they are out of that stage.\n" +
                "\n" +
                "We always tell ourselves that our life will be complete when our spouse gets his or her act together, when we get a nicer car, and are able to go on a nice vacation, when we retire. The truth is, there's no better time than right now. If not now, when? Our life will always be filled with challenges. It's best to admit this to ourselves and decide to be happy anyway.\n" +
                "\n" +
                "One of my favorite quotes comes from Alfred Souza. He said, \"For a long time it had seemed to me that life was about to begin-real life. But there was always some obstacle in the way, something to be gotten through first, some unfinished business, time still to be served, a debt to be paid. Then life would begin. At last it dawned onto me that these obstacles were my life. \"\n" +
                "\n" +
                "This perspective has helped me to see that there is no way to happiness. Happiness is the way. So treasure every moment that you have. And remember that time waits for no one. So stop waiting until you finish school, until you go back to school; until you get married, until you get divorced; until you have kids, until your kids leave home; until you start work, until you retire; until you get a new car or home; until spring; until you are born again to decide that there is no better time than right now to be happy....\n" +
                "\n" +
                "Happiness is a journey, not a destination. So, Work like you don't need money, Love like you've never been hurt, And dance like no one's watching.\n\nLook for the Extraordinary\n" +
                "\n" +
                "I heard a story about two workers who were approached by a reporter. The reporter asked the first worker, \"What are you doing? His response was to complain that he was virtually a slave, an underpaid bricklayer who spent his days wasting his time, placing bricks on the top of one another.\n" +
                "\n" +
                "The reporter asked the second worker the same question. His response, however, was quite different. \"I’m the luckiest person in the world, \"he said. \"I get to be a part of important and beautiful pieces of architecture. I help tum simple pieces of brick into exquisite masterpieces.”\n" +
                "\n" +
                "They were both right.\n" +
                "\n" +
                "The truth is, we see in life what we want to see. If you search for ugliness you’ll find plenty of it. If you want to find fault with other people, your career, or the world in general, you'll certainly be able to do so. But the opposite is also true.\n" +
                "\n" +
                "If you look for the extraordinary in the ordinary, your can train yourself to see it. This bricklayer sees cathedrals within pieces of brick. The question is, can you? Can you see the extraordinary synchronicity that exists in our world; the perfection of the universe in action; the extraordinary beauty of nature: the incredible miracle of human life? To me. it's all a matter of intention. There is so much to be grateful for, so much to be in awe about. Life is precious and extraordinary. Put your attention on this fact and little, ordinary things will take on a whole new meaning."));

        document.close();
    }
}
