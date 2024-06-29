package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.FileOutputStream;

/**
 *
 * @title  : 课程表
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 15:11
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _04CreateSchoolTimetable {

    public static void main(String[] args) throws Exception {
        XWPFDocument doc = new XWPFDocument();

        // 表头
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

        XWPFTable table = doc.createTable(5, 7);

        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTString ctString = tblPr.addNewTblStyle();
        ctString.setVal("课程表样式");

        int currentRow = 0, currentCell = 0;
        for(XWPFTableRow row : table.getRows()) {

            CTTrPr ctTrPr = row.getCtRow().addNewTrPr();

            // 设置行高
            CTHeight ctHeight = ctTrPr.addNewTrHeight();
            ctHeight.setVal(300);

            currentCell = 0;
            for(XWPFTableCell cell : row.getTableCells()) {
                CTTcPr ctTcPr = cell.getCTTc().addNewTcPr();

                CTVerticalJc ctVerticalJc = ctTcPr.addNewVAlign();
                ctVerticalJc.setVal(STVerticalJc.CENTER);

                CTShd ctShd = ctTcPr.addNewShd();
                ctShd.setColor("auto");
                ctShd.setVal(STShd.CLEAR);

                if(currentRow == 0) {
                    ctShd.setFill("708090");
                } else {
                    ctShd.setFill("90EE90");
                }

                XWPFParagraph paragraph = cell.getParagraphs().get(0);
                XWPFRun run = paragraph.createRun();
                if (currentRow == 0) {
                    run.setFontSize(18);
                    run.setFontFamily("楷体");
                    run.setText("header - " + currentCell);
                    paragraph.setAlignment(ParagraphAlignment.CENTER);
                } else {
                    run.setText(String.format("body - %d-%d", currentRow, currentCell));
                    paragraph.setAlignment(ParagraphAlignment.LEFT);
                }

                currentCell++;
            }

            currentRow++;
        }

        FileOutputStream outputStream = new FileOutputStream("E:/pdf/04SchollTimetable.docx");
        doc.write(outputStream);

        outputStream.close();

        System.out.println("Done!");
    }
}
