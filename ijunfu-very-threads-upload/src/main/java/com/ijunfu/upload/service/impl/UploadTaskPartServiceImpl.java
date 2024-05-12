package com.ijunfu.upload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ijunfu.common.id.NanoId;
import com.ijunfu.upload.entity.UploadTaskPart;
import com.ijunfu.upload.mapper.UploadTaskPartMapper;
import com.ijunfu.upload.service.UploadTaskPartService;
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
 * @Date   : 2024/5/10 10:20
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Service
public class UploadTaskPartServiceImpl extends ServiceImpl<UploadTaskPartMapper, UploadTaskPart> implements UploadTaskPartService {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void uploadPart(MultipartFile file, Long taskId, Integer partIndex) throws IOException {
        File dir = new File(uploadPath, String.valueOf(taskId));

        if(!dir.exists()) {
            dir.mkdirs();
        }

        // 原文件名
        String srcFileName = file.getOriginalFilename();

        // 新文件名
        String destFileName =
                String.format("%s%s", NanoId.randomNanoId(), srcFileName.substring(srcFileName.lastIndexOf(".")));
        File destFile = new File(dir, destFileName);

        file.transferTo(destFile);

        // 保存数据
        UploadTaskPart taskPart = new UploadTaskPart();
        taskPart.setTaskId(taskId);
        taskPart.setPartIndex(partIndex);
        taskPart.setPartPath(String.format("%d%s", taskId, destFileName));

        save(taskPart);
    }
}
