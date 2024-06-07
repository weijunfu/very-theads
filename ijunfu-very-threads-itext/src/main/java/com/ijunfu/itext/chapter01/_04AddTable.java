package com.ijunfu.itext.chapter01;

import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @Title  : 添加表格
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/7 10:32
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _04AddTable {

    public static void main(String[] args) {
        try(Document doc = new Document(new PdfDocument(new PdfWriter("E:/itext/ebooks_04.addTable.pdf")))) {

            // 引入第三方字体：思源字体
            String fontPath = new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath();
            PdfFont font = PdfFontFactory.createFont(fontPath, PdfFontFactory.EmbeddingStrategy.FORCE_EMBEDDED);
            doc.setFont(font).setFontSize(14).setFontColor(DeviceGray.GRAY);

            Table table = new Table(4)          // 4列
                            .useAllAvailableWidth();        // 自适应列宽

            table.addCell(
                    new Cell(2, 4)
                            .add(
                                    new Paragraph("用户信息表")
                                    .setFont(font)                                  // 设置字体
                                    .setFontSize(16)                                // 字体大小
                                    .setBold()                                      // 加粗
                                    .setFontColor(DeviceGray.GRAY)                  // 字体颜色
                            )
                            .setTextAlignment(TextAlignment.CENTER)                 // 水平居中
                            .setVerticalAlignment(VerticalAlignment.MIDDLE)         // 垂直居中
            );

            String[] headers = { "No.", "Name", "Age", "Birthday" };

            for(int i=0; i<headers.length; i++) {
                table.addCell(new Cell().add(new Paragraph(headers[i]).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE)));
            }

            String[][] datas = {
                    { "1", "张三", "18", "1990-01-01"},
                    { "2", "李四", "19", "1991-01-01"},
                    { "3", "王五", "20", "1992-01-01"},
                    { "4", "赵六", "21", "1993-01-01"},
                    { "5", "孙七", "22", "1994-01-01"},
                    { "6", "周八", "23", "1995-01-01"}
            };

            for(int i=0; i<datas.length; i++) {
                for(int j=0; j<datas[i].length; j++) {
                    table.addCell(datas[i][j]);
                }
            }

            doc.add(table);

            log.warn("添加表格成功");
        } catch (Exception ex) {
            log.error("添加表格失败", ex);
        }
    }
}
