package com.ijunfu.upload.controller.vo;

import lombok.Data;

import javax.annotation.processing.Completion;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 15:21
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
public class UploadTaskDetailVO implements Serializable {

    /* 任务id */
    private Long taskId;

    /* 任务分片数量 */
    private Integer partNums;

    /* 任务完成状态 */
    private Integer completionStatus;

    /* 已完成的分片任务列表 */
    private List<Integer> partIndexList;
}
