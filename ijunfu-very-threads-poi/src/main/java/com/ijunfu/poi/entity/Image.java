package com.ijunfu.poi.entity;

import lombok.Data;
import org.apache.poi.common.usermodel.PictureType;

import java.io.InputStream;

/**
 *
 * @title  : 
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/6/28 20:27
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
public class Image {

    private String name;

    private InputStream imageData;

    private PictureType type;

    private int width;

    private int height;
}
