package com.ijunfu.itext.chapter05;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 *
 * title  : 合并PDF文件
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 11:39
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _02MergePdf {

    public static final String DIR = "E:/itext/";

    public static void main(String[] args) throws IOException {

        // 初始化，预生成两个PDF文件
        genPdf("ebooks_52.hello.pdf", "Hello World!");
        genPdf("ebooks_52.greeting.pdf", "Hi! My name is ijunfu!");

        PdfDocument pdfDocument = new PdfDocument(new PdfWriter("E:/itext/ebooks_52.merge.pdf"));

        PdfMerger merger = new PdfMerger(pdfDocument);

        // 合并 第一个Pdf文件
        PdfDocument helloPdf = new PdfDocument(new PdfReader(DIR + "ebooks_52.hello.pdf"));
        merger.merge(helloPdf, 1, helloPdf.getNumberOfPages());

        // 合并 第二个Pdf文件
        PdfDocument greetingPdf = new PdfDocument(new PdfReader(DIR + "ebooks_52.greeting.pdf"));
        merger.merge(greetingPdf, 1, greetingPdf.getNumberOfPages());

        helloPdf.close();
        greetingPdf.close();
        pdfDocument.close();

    }


    public static void genPdf(String fileName, String content) {

        try(Document document = new Document(new PdfDocument(new PdfWriter(DIR + fileName)))) {


            document.add(new Paragraph(content));

        } catch (Exception ex) {
            log.error("merge pdf error: {}", ex.getMessage(), ex);
        }

    }
}
