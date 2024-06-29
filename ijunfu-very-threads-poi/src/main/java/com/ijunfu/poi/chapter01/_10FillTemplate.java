package com.ijunfu.poi.chapter01;

import cn.hutool.core.bean.BeanUtil;
import com.ijunfu.poi.chapter01.entity.User;
import com.ijunfu.poi.entity.Image;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @title  : Word表格模板数据填充
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 19:05
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _10FillTemplate {

    public final static String PATTERN = "\\{\\{(.+?)\\}\\}";

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = _10FillTemplate.class.getClassLoader();

        String file = classLoader.getResource("templates/user-list-template.docx").getFile();

        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 18, "2024-06-28", "avatar/female.png"));
        userList.add(new User("李四", 19, "2024-06-28", "avatar/male.png"));
        userList.add(new User("王五", 20, "2024-06-28", "logo.png"));

        String AVATAR = "avatar";

        List<Map<String, Object>> list =
                userList.stream()
                        .map(user -> {
                            Map<String, Object> map = BeanUtil.beanToMap(user);

                            String avatar = map.get(AVATAR).toString();
                            Image image = new Image();
                            image.setImageData(classLoader.getResourceAsStream(avatar));
                            image.setType(PictureType.PNG);
                            image.setName(avatar);
                            image.setWidth(Units.toEMU(540));
                            image.setHeight(Units.toEMU(258));

                            map.put(AVATAR, image);
                            return map;
                        }).collect(Collectors.toList());

        FileInputStream fis = new FileInputStream(file);
        XWPFDocument document = new XWPFDocument(fis);

        List<XWPFTable> tables = document.getTables();

        // key=列索引，value=列属性名
        Map<Integer, String> columnMap = new HashMap<>();
        int startRowIndex = 0;
        Boolean startFill = Boolean.FALSE;

        for(int tableIndex=0; tableIndex<tables.size(); tableIndex++) {
            XWPFTable table = tables.get(tableIndex);

            for(int rowIndex=0; rowIndex<table.getRows().size(); rowIndex++) {

                XWPFTableRow row = table.getRow(rowIndex);

                StringBuilder sb = new StringBuilder();
                for(int colIndex = 0; colIndex < row.getTableCells().size(); colIndex++) {
                    XWPFTableCell cell = row.getCell(colIndex);
                    String text = cell.getText();
                    sb.append(text).append("\t");

                    Matcher matcher = Pattern.compile(PATTERN).matcher(text);

                    if(matcher.find()) {
                        cell.setText("");

                        String name = matcher.group(1);
                        columnMap.put(colIndex, name);

                        if(!startFill) {
                            startFill = Boolean.TRUE;
                        }
                        System.out.println(String.format("row=%d col=%d\t%s", rowIndex, colIndex, name));

//                        Map<String, Object> map = list.get(startRowIndex);
//                        System.out.println(map);

                        Object o = list.get(startRowIndex).get(columnMap.get(colIndex));

                        if(o instanceof Image) {
                            Image image = (Image) o;
                            XWPFParagraph paragraph = cell.addParagraph();
                            XWPFRun run = paragraph.createRun();
                            run.addPicture(image.getImageData(), image.getType(), image.getName(), Units.toEMU(64), Units.toEMU(64));
                        } else {
                            cell.setText(o.toString());
                        }
//                        cell.setText(list.get(startRowIndex).get(columnMap.get(colIndex)).toString());
                    }

//                    System.out.println(text + "\t" + (matcher.find() ? matcher.group(1):matcher.groupCount()));
                }

                if(startFill) {
                    startRowIndex++;
                }
                System.out.println(sb.toString());
            }

            if(startRowIndex < list.size()) {

                for(int rowIndex=startRowIndex; rowIndex<list.size(); rowIndex++) {

                    XWPFTableRow row = table.createRow();

                    for(int columnIndex=0; columnIndex<columnMap.size(); columnIndex++) {
                        XWPFTableCell cell = null;
                        if(columnIndex==0) {
                            cell = row.getCell(columnIndex);
                        } else  {
                            cell = row.createCell();
                        }
                        Object o = list.get(rowIndex).get(columnMap.get(columnIndex));

                        if(o instanceof Image) {
                            Image image = (Image) o;
                            XWPFParagraph paragraph = cell.addParagraph();
                            XWPFRun run = paragraph.createRun();
                            run.addPicture(image.getImageData(), image.getType(), image.getName(), Units.toEMU(64), Units.toEMU(64));
                        } else {
                            cell.setText(o.toString());
                        }

                    }
                }

            }
        }

        System.out.println(columnMap);
        System.out.println(startRowIndex);

        FileOutputStream outputStream = new FileOutputStream("E:/pdf/10FillTableTemplate.docx");

        document.write(outputStream);

        outputStream.flush();
        outputStream.close();

        fis.close();
    }
}
