package com.ijunfu.upload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ijunfu.upload.controller.vo.UploadTaskVO;
import com.ijunfu.upload.entity.UploadTask;

/**
 *
 * @Title  : 上传任务处理类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 9:52
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public interface UploadTaskService extends IService<UploadTask> {

    UploadTask createTask(UploadTaskVO vo);

}
