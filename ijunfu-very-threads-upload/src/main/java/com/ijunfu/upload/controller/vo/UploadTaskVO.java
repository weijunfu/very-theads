package com.ijunfu.upload.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 15:26
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
public class UploadTaskVO implements Serializable {

    /* 文件名 */
    private String fileName;

    /* 分片数量 */
    private Integer partNums;

    /* 文件MD5值 */
    private String fileMd5;

    /* 文件路径 */
    private String filePath;
}
