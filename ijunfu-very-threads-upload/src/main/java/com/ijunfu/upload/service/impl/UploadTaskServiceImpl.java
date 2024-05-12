package com.ijunfu.upload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ijunfu.common.id.NanoId;
import com.ijunfu.upload.controller.vo.UploadTaskVO;
import com.ijunfu.upload.entity.UploadTask;
import com.ijunfu.upload.entity.UploadTaskPart;
import com.ijunfu.upload.mapper.UploadTaskMapper;
import com.ijunfu.upload.service.UploadTaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 9:52
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Service
public class UploadTaskServiceImpl extends ServiceImpl<UploadTaskMapper, UploadTask> implements UploadTaskService {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public UploadTask createTask(UploadTaskVO vo) {

        UploadTask task = new UploadTask();

        // 属性值复制
        BeanUtils.copyProperties(vo, task);

        // 保存上传任务信息
        this.save(task);

        return task;
    }

}
