package com.ijunfu.itext.html.chapter01;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.FileNotFoundException;

/**
 *
 * @title  : 
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/15 10:19
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _HelloWorld {

    public static void main(String[] args) throws FileNotFoundException {
        String html = "<h1>Test</h1><p>Hello World!</p>";
        HtmlConverter.convertToPdf(html, new PdfWriter("E:/itext/html_01_hello.pdf"));
    }
}
