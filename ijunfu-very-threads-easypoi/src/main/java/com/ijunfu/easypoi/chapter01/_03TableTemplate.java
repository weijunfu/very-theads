package com.ijunfu.easypoi.chapter01;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import cn.hutool.core.bean.BeanUtil;
import com.ijunfu.easypoi.chapter01.entity.User;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @title  : 表格填充模板
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 10:46
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服

 */
public class _03TableTemplate {

    public static void main(String[] args) throws Exception {
        String AVATAR = "avatar";

        List<User> users = new ArrayList<>();

        // TODO Tips：图片被第一个图片替换了
        users.add(new User("ijunfu", 18, "2022-01-21", "avatar/female.png"));
        users.add(new User("tesila", 16, "2024-12-17", "avatar/male.png"));
        users.add(new User("wei", 12, "2024-06-28", "avatar/male.png"));

        List<Map<String, Object>> list = users.stream().map(user -> {
            Map<String, Object> map = BeanUtil.beanToMap(user);

            String avatar = map.get(AVATAR).toString();

            ImageEntity image = new ImageEntity();
            image.setWidth(130);
            image.setHeight(130);
            image.setType(ImageEntity.URL);
            image.setUrl(avatar);

            map.put(AVATAR, image);
            return map;
        }).collect(Collectors.toList());

        XWPFDocument xwpfDocument = WordExportUtil.exportWord07("templates/user-list-template.docx", list);

        OutputStream outputStream = new FileOutputStream("E:/pdf/user-list.docx");

        xwpfDocument.write(outputStream);

        outputStream.flush();
        outputStream.close();

        xwpfDocument.close();

        System.out.println("Done!");
    }

}
