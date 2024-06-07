package com.ijunfu.itext.chapter03;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/7 17:50
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class _01Renderers {

    public static final PdfFont font;

    static {
        try {
            font = PdfFontFactory.createFont(new ClassPathResource("fonts/SourceHanSerifCN-VF.otf_2.woff2").getFile().getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        PdfWriter pdfWriter = new PdfWriter("E:/itext/ebooks_31.renderers.pdf");

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        PageSize ps = PageSize.A5;

        Document document = new Document(pdfDocument, ps);

        // Set column parameters
        float offset = 36;
        float columnWidth = (ps.getWidth() - offset*2+10) / 3;  // 三列
        float columnHeight = ps.getHeight() - offset*2;

        // Define column areas
        Rectangle[] columns = {
          new Rectangle(offset -5, offset, columnWidth, columnHeight),
          new Rectangle(offset + columnWidth, offset, columnWidth, columnHeight),
          new Rectangle(offset + columnWidth*2 + 5, offset, columnWidth, columnHeight)
        };
        document.setRenderer(new ColumnDocumentRenderer(document, columns));

        String[][] datas = {
                {"“更有针对性地为大众服务”——与舍费尔教授的一次会面", "images/render01.jpg", "徐 馨《人民日报》（2024年06月07日 第17版）", "在德国近6000座博物馆中，位于波恩的德国历史之家（又名联邦德国历史博物馆）格外与众不同。自1994年开馆以来，一直深受人们喜爱。德国历史之家开放15个月时，就迎来了100万人次的访客，其访客人数在德国众多博物馆中始终位居前列，并获得欧洲博物馆奖等诸多奖项。\n" +
                        "\n" +
                        "　　赫尔曼·舍费尔，历史学家、国际博物馆专家。作为德国历史之家创建人，舍费尔教授在担任馆长的20年时间里，见证了这座当代历史博物馆从无到有、从探索性创新实践到对公众保持吸引力的变化与成长。2021年，他撰写的《100个物品中的德国历史》在中国翻译出版。这本书如一粒种子，生发出舍费尔与中国的缘分。2023年11月，中国对法国、德国等六国旅客免签政策生效，更直接在舍费尔和中国之间架起畅达的桥梁：这一年12月，81岁的他第一次踏上中国的土地。\n" +
                        "\n" +
                        "　　带着对德国历史之家何以深受大众喜爱的探究，以及对舍费尔初次访问中国感受的好奇，我走进初夏时节的波恩，拜访久居在此的舍费尔。\n" +
                        "\n" +
                        "　　营造出回忆与历史可被感知的情境\n" +
                        "\n" +
                        "　　轻轨自波恩火车站一路向南，开阔的莱茵河在远处熠熠发光，骑行的人们迅速从眼前闪过。随着行人越来越少，满目的新绿愈发浓郁起来。如同被一条绿色小披肩轻轻裹着，舍费尔的家安静地坐落在莱茵河畔。按响门铃，眼前的舍费尔高大挺拔，精神矍铄，洋溢着青年人一般的蓬勃热情。\n" +
                        "\n" +
                        "　　1942年，舍费尔出生于马克思的故乡、有着2000多年历史的古城特里尔。上世纪60年代中期，作为学生的他初次来到波恩，他说：“1965年离开波恩时，我和这里的朋友们说我会很快回来，没想到一别就是20年。”\n" +
                        "\n" +
                        "　　1982年，当时的德意志联邦共和国政府总理赫尔穆特·科尔宣布，将在波恩建造一座博物馆，以展示第二次世界大战结束以来的德国历史。1987年，舍费尔被聘为德国历史之家首任馆长，负责这座新型博物馆的具体筹划建造。\n" +
                        "\n" +
                        "　　“在如何阐释历史方面，我受法国年鉴学派影响很大。”舍费尔说道，“年鉴学派主张历史有三个层面：长时段历史如千百年来的气候改变，中时段历史如几十年间的经济变化，短时段历史如突发重大事件。德国历史之家表现的是中时段和短时段历史。我主张从普通人的日常生活出发，通过一个个具体的‘人’的故事展示历史。”\n" +
                        "\n" +
                        "　　这或许就是德国历史之家为一代代人喜爱的原因之一。7000余件展品跨越80余年，从汽车、火车车厢到日记、信件、照片，除重大历史事件外，几乎每一件物品都有自己的主人、自己的故事，这些承载着几代人记忆的故事共同拼成“我们的历史”。比如展厅中一辆破旧的“尊达普运动型小摩托”是大量外籍劳工助力德国实现经济发展奇迹的缩影，也凝结了德国社会对外来移民的复杂感情。1964年，这辆小摩托作为礼物，赠给刚下火车的葡萄牙人阿尔曼多·罗德里格斯·德·萨：他正好是德国第100万名外籍劳工。\n" +
                        "\n" +
                        "　　“‘你得通过看展学到些什么’，这是人们的普遍观念，但我相信带着情感学习往往能学得更好，历史学习尤其如此。所以，我希望博物馆首先能唤起人的情感。”舍费尔说。在表现第二次世界大战结束后日常生活的展厅，人们可以在带有上世纪50年代风情的电影院观看旧广告、在点唱机上播放时代金曲，营造出回忆与历史可被感知的情境。\n" +
                        "\n" +
                        "　　舍费尔说：“我们的策展思路是‘以参观为导向’，即不是以‘你应该看什么’为主导，而是强调‘你想看什么’。我们的服务对象不是专家或者研究者，是对历史了解不多的大多数人；不是经常进博物馆的人，是几乎从不看展的人——我们想建立普通人和博物馆的连接。”\n" +
                        "\n" +
                        "　　从1987年开始策展到1994年正式开馆，德国历史之家举办了6次大型公共工作坊式的展览。舍费尔联合社会学家、心理学家、历史学家等多学科专业人士，对不同主题展览进行“试水”。“我们邀请大家来看展览，记录每个人在每件物品前的停留时间，并与每个人交谈，根据大家的反馈调整展陈方式，更有针对性地为大众服务。”\n" +
                        "\n" +
                        "　　德国历史之家已经成为博物馆叙述历史的典范。在德国，巴登—符腾堡州历史之家于2002年开放，北莱茵—威斯特法伦州等地的历史之家正在筹建。2017年，以德国历史之家为蓝本的欧洲历史之家开馆，博物馆位于比利时首都布鲁塞尔，由欧洲议会设立，主要展示从1789年至今的欧洲历史。\n" +
                        "\n" +
                        "　　在舍费尔看来，历史不是封闭的年代，博物馆也应和当代史一起继续书写、时时更新，“就像我们收藏部经理说的那样，我们的工作是从街头到博物馆”。30年来，德国历史之家常设展不断更新，并开设“德国数字化”等具有当下话题性的临时展，保持着对民众的吸引力。\n" +
                        "\n" +
                        "　　退休后，舍费尔撰写了《100个物品中的德国历史》，从史前史直至今天，时间跨度2000余年。与他的策展思路一脉相承，舍费尔在遴选历史物品时，把普通人的情感和阅读需求放在首位。2021年，这套深入浅出、有故事、有情感的历史书被引进中国，开启了舍费尔的中国缘。\n" +
                        "\n" +
                        "　　为人与人的交流创造更多机会\n" +
                        "\n" +
                        "　　“我对中国很好奇，但以前对中国的认识只是德国人的平均水平。这次旅行让我对任何与中国有关的问题都非常谦逊，不会轻易作答：从零下20摄氏度的长春到30多摄氏度的广州，这个国家地大物博，饮食、方言、建筑等无不多种多样，总是在不断更新我的认知。”回忆起去年冬天的中国行，舍费尔由衷感叹。\n" +
                        "\n" +
                        "　　在中国学界和德国同事的热情帮助下，舍费尔先后前往上海、广州、青岛、长春和北京，既举办学术沙龙也感受风土人情。受北京外国语大学历史学院院长、德国国家科学院院士李雪涛邀请，舍费尔走进北京外国语大学，年轻学生积极向上的精神面貌给他留下了深刻印象。“我去故宫的那一天正好下着大雪，景色非常壮观；长春电影博物馆让我了解到这座城市对中国电影发展有着重要贡献；广州的一座小型茶博物馆让我感到十分新奇；青岛正在筹建警察博物馆，我回到德国后也帮助他们搜集材料……”\n" +
                        "\n" +
                        "　　归国之后，舍费尔更加关注与中国有关的信息与书籍。从《四书五经选译》《中国现代史》到《爱中国的111个理由》《深圳：未来中国制造》，书架上与中国相关的书日渐丰富，他常常浏览的新闻网站也增添了人民网德语版。\n" +
                        "\n" +
                        "　　提及去年的中国之旅，舍费尔带着一丝怀念和更多的向往说：“我很期待再次启程去中国。接下来，我想写一本《88个物品中的中德文化交流史》，谈一谈两国都有的啤酒酿造技艺、贝多芬的音乐遗产，以及两国各自的母亲河黄河和莱茵河的故事，等等。”\n" +
                        "\n" +
                        "　　“国之交在于民相亲，民相亲在于心相通。”舍费尔希望德中人民之间开展更多交流，在文博、文学、电影、音乐等领域增加合作。他微笑着说：“在中国各地访问、与中国朋友面对面交流所带来的感受，是其他形式的了解所无法替代的，我们需要为人与人的交流创造更多机会。就像此刻，你我之间这种面对面的交流是最宝贵的。”"}
        };

        for(int i=0; i<datas.length; i++) {

            String title = datas[i][0];

            String imagePath = new ClassPathResource(datas[i][1]).getFile().getPath();
            ImageData imageData = ImageDataFactory.create(imagePath);

            String author = datas[i][2];
            String content = datas[i][3];

            addArticle(document,title, author, new Image(imageData), content);
        }

        document.close();
    }

    private static void addArticle(Document doc, String title, String author, Image image, String text) {

        Paragraph titleParagraph = new Paragraph(title)
                .setFont(font)
                .setFontSize(14);

        Paragraph authorParagraph = new Paragraph(author)
                .setFont(font)
                .setFontSize(7)
                .setFontColor(DeviceGray.GRAY);

        Paragraph textParagraph = new Paragraph(text)
                .setFont(font)
                .setFontSize(10);

        doc.add(titleParagraph);
        doc.add(image);
        doc.add(authorParagraph);
        doc.add(textParagraph);
    }
}
