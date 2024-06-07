package com.ijunfu.itext.chapter01;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @Title  : 添加图片
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/6/7 10:22
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class _03AddImage {

    public static void main(String[] args) {
        try(Document document = new Document(new PdfDocument(new PdfWriter("E:/itext/ebooks_03.addImage.pdf")))) {
            String imagePath = new ClassPathResource("images/fu.jpg").getFile().getPath();

            ImageData imageData = ImageDataFactory.create(imagePath);
            Image image = new Image(imageData);

            document.add(image);

        } catch (Exception ex) {
            log.error("gen pdf error", ex);
        }
    }
}
