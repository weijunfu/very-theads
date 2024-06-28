package com.ijunfu.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @title  : 
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/27 20:41
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
class ApplicationTest {

    @Test
    void createPdf() throws IOException {
        // Step 1: Initialize a PDF document
        PDDocument doc = new PDDocument();

        // Step 2: Create a new page
        PDPage firstPage = new PDPage();

        // Step 3: Add the page to the document
        doc.addPage(firstPage);

        // Step 4: Save the document
        doc.save("E:/pdf/first.pdf");

        // Step 5: Close the document
        doc.close();
    }

    @Test
    void greeting() throws IOException {
        PDDocument doc = new PDDocument();

        PDPage page = new PDPage();
        doc.addPage(page);

        PDPageContentStream content = new PDPageContentStream(doc, page);
        content.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 18);
        content.setLeading(16f);

        content.beginText();
        content.newLineAtOffset(25, page.getMediaBox().getHeight() - 25);
        content.showText("Hello World! @ijunfu");

        content.endText();
        content.close();

        doc.save("E:/pdf/greeting.pdf");
        doc.close();
    }
}