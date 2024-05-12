package com.ijunfu.upload.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title  : 分片上传任务实体
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 0:27
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
@TableName("upload_task")
public class UploadTask implements Serializable {

    private static final long serialVersionUID = 121729L;

    /* 分片任务Id - 主键 */
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;

    /* 文件名 */
    private String fileName;

    /* 分片数量 */
    private Integer partNums;

    /* 文件MD5值 */
    private String fileMd5;

    /* 文件路径 */
    private String filePath;

    /* 删除状态 */
    private Integer delStatus;
}
