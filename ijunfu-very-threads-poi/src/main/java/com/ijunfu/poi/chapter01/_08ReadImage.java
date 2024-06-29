package com.ijunfu.poi.chapter01;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;

/**
 *
 * @title  : 提取图片
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 18:45
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _08ReadImage {

    public static void main(String[] args) throws Exception {
        String file = "E:/pdf/10FillTableTemplate.docx";
        FileInputStream fis = new FileInputStream(file);

        XWPFDocument doc = new XWPFDocument(fis);

        for(XWPFParagraph paragraph : doc.getParagraphs()) {

            for(XWPFRun run : paragraph.getRuns()) {

                for(XWPFPicture picture : run.getEmbeddedPictures()) {
                    XWPFPictureData pictureData = picture.getPictureData();
                    System.out.println(pictureData.getFileName());
                    System.out.println(pictureData.getPictureType());
                    System.out.println(pictureData.getPictureTypeEnum().contentType);

//                    FileOutputStream outputStream = new FileOutputStream("E:/pdf/logo.png");
//                    outputStream.write(pictureData.getData());
//                    outputStream.flush();
//                    outputStream.close();
                }

            }

        }

//        System.out.println(doc.getAllPictures());
        doc.getAllPictures().forEach(pic -> {
            System.out.println(pic.getFileName());

//            String extension = pic.getPictureTypeEnum().extension;
//            System.out.println(extension);

            try (FileOutputStream outputStream = new FileOutputStream(new File("E:/pdf", pic.getFileName()))){

                outputStream.write(pic.getData());
                outputStream.flush();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        fis.close();
    }
}
