package com.ijunfu.itext.chapter06;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.filespec.PdfFileSpec;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.pdfa.PdfADocument;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 *
 * title  : 附件
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 16:36
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _03Attachments {

    public final static String DATA = "data/countries.csv";

    public static void main(String[] args) throws IOException {

        PdfDocument pdfDoc = new PdfDocument(
                new PdfWriter("E:/itext/ebooks_63.attachments.pdf")
        );

        pdfDoc.setTagged();
        pdfDoc.getCatalog().setLang(new PdfString("zh-CN"));
        pdfDoc.getCatalog().setViewerPreferences(
          new PdfViewerPreferences().setDisplayDocTitle(Boolean.TRUE)
        );

        PdfDocumentInfo docInfo = pdfDoc.getDocumentInfo();
        docInfo.setTitle("iText8 PDF/A-3 example");

        PdfDictionary params = new PdfDictionary();
        params.put(PdfName.ModDate, new PdfDate().getPdfObject());

        PdfFileSpec fileSpec = PdfFileSpec.createEmbeddedFileSpec(
                pdfDoc,
                Files.readAllBytes(Paths.get(new ClassPathResource(DATA).getFile().getPath())),
                "countries.csv",
                "countries.csv",
                new PdfName("text/csv"),
                params,
                PdfName.Data
        );
        fileSpec.put(new PdfName("countries"), new PdfName("Data"));

        pdfDoc.addFileAttachment("countries.csv", fileSpec);

        PdfArray array = new PdfArray();
        array.add(fileSpec.getPdfObject().getIndirectReference());

        pdfDoc.getCatalog().put(new PdfName("countries"), array);

        PdfFont font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath(), PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);


        Document doc = new Document(pdfDoc, PageSize.A4.rotate());
        doc.setFont(font);

        Table table = new Table(2).useAllAvailableWidth();

        File file = new ClassPathResource(DATA).getFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            process(table, line, font);
        }
        br.close();

        doc.add(table);

        doc.close();
    }

    private static void process(Table table, String line, PdfFont font) {
        StringTokenizer st = new StringTokenizer(line, ",");

        String name = st.nextToken();
        String allName = st.nextToken();

        table.addCell(new Cell().add(new Paragraph(name).setFont(font)));
        table.addCell(new Cell().add(new Paragraph(allName).setFont(font)));
    }
}
