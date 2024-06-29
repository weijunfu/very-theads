package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;

/**
 *
 * @title  : 高中课程表
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 16:03
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _05CreateSchoolTimetable {

    public final static String[] SUBJECT_LIST = {
            "语文", "数学", "英语", "物理", "化学", "生物", "政治", "地理", "历史", "体育", "美术"
    };

    public static void main(String[] args) throws Exception {

        XWPFDocument docx = new XWPFDocument();

        CTDocument1 document = docx.getDocument();

        CTBody body = document.getBody();

        if(!body.isSetSectPr()) {
            body.addNewSectPr();
        }

        CTSectPr section = body.getSectPr();

        if(!section.isSetPgSz()) section.addNewPgSz();

        // 设置页面大小
        CTPageSz pageSize = section.getPgSz();
        pageSize.setW(BigInteger.valueOf(18000));
        pageSize.setH(BigInteger.valueOf(12000));
        pageSize.setOrient(STPageOrientation.LANDSCAPE);

        // 设置课程标题
        XWPFParagraph titleParagraph = docx.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText("高三（二）班课程表");
        titleRun.setBold(true);
        titleRun.setColor("000000");
        titleRun.setFontFamily("楷体");
        titleRun.setFontSize(22);

        // 创建二级标题
        XWPFParagraph teacherParagraph = docx.createParagraph();
        XWPFRun teacherRun = teacherParagraph.createRun();
        teacherRun.setText("班主任：ijunfu");
        teacherRun.setFontFamily("宋体");
        teacherRun.setFontSize(18);
        teacherParagraph.insertNewRun(1).addBreak();

        // 创建课程表格
//        int rows = 8, cols = 7;
        XWPFTable table = docx.createTable(8, 7);
        table.setWidth("100%");

        // 给课程表添加样式
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTString tableStyle = tblPr.addNewTblStyle();
        tableStyle.setVal("课程表格样式");

        List<XWPFTableRow> rowList = table.getRows();

        // 控制单元格的合并 - 跨行合并
        CTVMerge startMerge = CTVMerge.Factory.newInstance();
        startMerge.setVal(STMerge.RESTART);
        CTVMerge endMerge = CTVMerge.Factory.newInstance();
        endMerge.setVal(STMerge.CONTINUE);

        int currentRow = 0, currentColumn = 0;
        for(XWPFTableRow row : rowList) {
            CTTrPr ctTrPr = row.getCtRow().addNewTrPr();
            CTHeight ctHeight = ctTrPr.addNewTrHeight();

            if(currentRow == 0) {
                ctHeight.setVal(BigInteger.valueOf(500));
            } else {
                ctHeight.setVal(BigInteger.valueOf(200));
            }

            for(XWPFTableCell cell : row.getTableCells()) {

                CTTcPr ctTcPr = cell.getCTTc().addNewTcPr();
                CTVerticalJc ctVerticalJc = ctTcPr.addNewVAlign();
                ctVerticalJc.setVal(STVerticalJc.CENTER);

                XWPFParagraph cellParagraph = cell.getParagraphs().get(0);
                cellParagraph.setAlignment(ParagraphAlignment.CENTER);

                XWPFRun run = cellParagraph.createRun();
                run.setFontFamily("宋体");

                if(currentRow == 0 && (currentColumn == 0 || currentColumn == 1)) {
                    // 合并第一行的前两个单元格
                    if(currentColumn == 0) {
                        run.setText("时间\\星期");
                        run.setFontSize(18);
                        run.setBold(Boolean.TRUE);
                        ctTcPr.addNewHMerge().setVal(STMerge.RESTART);
                    } else {
                        ctTcPr.addNewHMerge().setVal(STMerge.CONTINUE);
                    }
                } else if(currentRow == 0){
                    // 填充星期
                    String[] weeks = { "星期一", "星期二", "星期三", "星期四", "星期五" };
                    run.setFontSize(18);
                    run.setBold(Boolean.TRUE);
                    run.setText(weeks[currentColumn-2]);

                } else  {
                    if (currentColumn == 0 && currentRow <  5) {
                        if(currentRow == 1) {
                            run.setBold(Boolean.TRUE);
                            ctTcPr.setVMerge(startMerge);
                            run.setText("上午");
                            run.setFontSize(18);
                        }
                        ctTcPr.setVMerge(endMerge);
                    } else if(currentColumn == 0 && currentRow >  4) {

                        if(currentRow == 5) {
                            ctTcPr.setVMerge(startMerge);
                            run.setBold(Boolean.TRUE);
                            run.setText("上午");
                            run.setFontSize(18);
                        }
                        cell.getCTTc().addNewTcPr().setVMerge(endMerge);
//                        ctTcPr.setVMerge(endMerge);  // TODO bug 合并内容消失
                    } else if (currentColumn == 1){
                        run.setFontSize(16);
                        run.setBold(Boolean.TRUE);
                        run.setText(String.format("第%d节", currentRow));

                    } else {
                        run.setText(randomSubject());
                        cellParagraph.setAlignment(ParagraphAlignment.RIGHT);
                    }
                }

                currentColumn++;
            }

            currentRow++;
            currentColumn = 0;
        }



        // 保存文件
        FileOutputStream outputStream = new FileOutputStream("E:/pdf/05SchoolTimetable.docx");
        docx.write(outputStream);

        outputStream.close();

        System.out.println("Done!");
    }

    private static Random random = new Random();
    private static String randomSubject() {
        int index = random.nextInt(SUBJECT_LIST.length);
        return SUBJECT_LIST[index];
    }
}
