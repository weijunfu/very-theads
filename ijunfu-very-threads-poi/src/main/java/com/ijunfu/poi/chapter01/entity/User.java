package com.ijunfu.poi.chapter01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @title  : 用户信息
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 10:52
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    /* 姓名 */
    private String name;

    /* 年龄 */
    private Integer age;

    /* 生日 */
    private String birthday;

    /* 头像 */
    private String avatar;

}
