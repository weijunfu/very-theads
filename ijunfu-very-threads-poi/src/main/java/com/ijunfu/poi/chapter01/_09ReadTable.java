package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;

/**
 *
 * @title  : 读取表格
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 18:55
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _09ReadTable {

    public static void main(String[] args) throws Exception {
        String file = "E:/pdf/05SchoolTimetable.docx";

        FileInputStream fis = new FileInputStream(file);

        XWPFDocument doc = new XWPFDocument(fis);

        for(XWPFTable table : doc.getTables()) {

            for(XWPFTableRow row : table.getRows()) {

                StringBuilder sb = new StringBuilder();

                for (XWPFTableCell cell : row.getTableCells()) {
                    sb.append(cell.getText())
                            .append("\t");
                }

                System.out.println(sb.toString());
            }

        }

        fis.close();
    }
}
