package com.ijunfu.itext.chapter01;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @Title  : 向PDF中添加列表
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/6 21:34
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _02AddList {

    public static void main(String[] args) throws IOException {
        PdfWriter pdfWriter = new PdfWriter("E:/itext/ebooks_02.addList.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        Document document = new Document(pdfDocument);

        // Add a Paragraph
        document.add(new Paragraph("Languages: "));

        // Create a List
        List list = new List()
                .setSymbolIndent(12)        // 缩进大小
                .setListSymbol("\u2022")    // 小黑圆点，必须使用字体支持的字符，否则不显示
                .setFont(PdfFontFactory.createFont(StandardFonts.COURIER))
                ;

        // Add List Item
        list.add("Java");
        list.add("Rust");
        list.add("Lua");
        list.add(new ListItem("Go"));

        // Create a ListItem object
        ListItem cItem = new ListItem();
        cItem.add(new Paragraph("C"));
        // Create second level List
        List cList = new List()
                .setSymbolIndent(10)        // 缩进大小
                .setListSymbol("\u2013")    // 短横线，必须使用字体支持的字符，否则不显示
                .setFont(PdfFontFactory.createFont(StandardFonts.COURIER_OBLIQUE));
        cList.add("C");
        cList.add("C++");
        cList.add("C#");
        // Add second level List
        cItem.add(cList);

        // Add ListItem
        list.add(cItem);

        // Add the list
        document.add(list);

        document.close();

    }

}
