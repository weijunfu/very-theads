package com.ijunfu.easypoi.chapter01;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @title  : 图片填充模板
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 10:36
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _02ImageTemplate {

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();

        ImageEntity image = new ImageEntity();
        image.setWidth(64);
        image.setHeight(64);
        image.setType(ImageEntity.URL);
        image.setUrl("logo.png");

        data.put("image", image);

        XWPFDocument xwpfDocument = WordExportUtil.exportWord07("templates/image-template.docx", data);

        OutputStream outputStream = new FileOutputStream("E:/pdf/image.docx");

        xwpfDocument.write(outputStream);

        outputStream.flush();
        outputStream.close();

        xwpfDocument.close();

        System.out.println("Done!");
    }

}
