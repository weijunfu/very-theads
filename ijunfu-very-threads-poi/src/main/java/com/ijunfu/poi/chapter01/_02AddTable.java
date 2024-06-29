package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @title  : 创建表格
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 14:24
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _02AddTable {

    public static void main(String[] args) throws IOException {
        XWPFDocument doc = new XWPFDocument();

        XWPFTable table = doc.createTable();
        table.setWidth("100%");

        String[][] data = {
                {"张三", "男", "20", "北京"},
                {"李四", "女", "21", "上海"},
                {"王五", "男", "22", "广州"},
                {"赵六", "女", "23", "深圳"},
        };

        // 标题
        String[] heads = { "姓名", "性别", "年龄", "地址" };
        XWPFTableRow headRow = table.getRow(0);
        for (int i = 0; i < heads.length; i++) {
            XWPFTableCell cell = (i==0) ? headRow.getCell(0) : headRow.createCell();
            cell.setText(heads[i]);
        }

        for (int i = 1; i < data.length; i++) {
            XWPFTableRow row = table.createRow();

            for (int j = 0; j < data[i].length; j++) {
                XWPFTableCell cell = row.getCell(j);
                cell.setText(data[i][j]);
            }
        }

        FileOutputStream outputStream = new FileOutputStream("E:/pdf/02AddTable.docx");
        doc.write(outputStream);

        outputStream.close();

        System.out.println("Done!");
    }
}
