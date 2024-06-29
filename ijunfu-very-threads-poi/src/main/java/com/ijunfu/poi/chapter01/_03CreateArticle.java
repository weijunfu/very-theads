package com.ijunfu.poi.chapter01;

import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;

/**
 *
 * @title  : 写一篇文章
 *          第一段：文章标题
 *          第二段：文章内容
 *          第三段：文章结尾
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 14:46
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _03CreateArticle {

    public static void main(String[] args) throws Exception {
        XWPFDocument doc = new XWPFDocument();

        // Word文件属性
        POIXMLProperties.CoreProperties properties = doc.getProperties().getCoreProperties();
        properties.setCategory("开发-学习");
        properties.setTitle("学会感恩");
        properties.setCreated("2024-06-28");
        properties.setCreator("@ijunfu");

        // 第一段：文章标题
        XWPFParagraph title = doc.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);  // 居中
        XWPFRun titleRun = title.createRun();
        titleRun.setText("学会感恩");
        titleRun.setBold(Boolean.TRUE);         // 加粗
        titleRun.setFontSize(30);               // 字体大小
        titleRun.setFontFamily("微软雅黑");

        // 第二段：文章内容
        XWPFParagraph content = doc.createParagraph();
        content.setIndentationFirstLine(400);
        XWPFRun contentRun = content.createRun();
        contentRun.setFontFamily("宋体");
        contentRun.setText("感恩在严冬里为我们洗衣服的母亲，感恩在烈日下辛勤工作的父亲，是他们养育了我们，给了我们一个安定幸福的家。从我们呱呱坠地到蹒跚学步，再到上学识字，是他们一直陪伴着我们。父母对我们的爱，比天高，比海深，却有如水般平淡，因为我们已经习以为常。学校里开展了一项“两个一”感恩活动，回家给父母端一杯热茶，洗一次脚。我抚摸着泡在洗脚盘里的脚，我的心一下酸了，父母的脚是那样粗糙，我看到了岁月留下的痕迹，看到了父母付出的心血与汗水，我流泪了。");

        // 第三段：文章结尾
        XWPFParagraph end = doc.createParagraph();
        end.setIndentationFirstLine(400);
        XWPFRun endRun = end.createRun();
        endRun.setFontFamily("宋体");
        endRun.setText("感恩灯光下为我们批改作业的老师，他们默默的奉献着自己的青春。为了教书育人，他们的青丝被染成了白发；为了传播知识，他们奉献了一生。春蚕到死丝方尽，蜡炬成灰泪始干。感恩这些无私奉献的`老师，是他们教会我们知识，引领我们进入知识的殿堂，让我们知道了用知识来改变自己的命运。这些引领我们前进，希望我们拥有一个完美人生的人，不值得我们感恩吗？");

        FileOutputStream outputStream = new FileOutputStream("E:/pdf/03AddArticle.docx");
        doc.write(outputStream);

        outputStream.close();

        System.out.println("Done!");
    }
}
