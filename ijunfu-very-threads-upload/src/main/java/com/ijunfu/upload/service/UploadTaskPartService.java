package com.ijunfu.upload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ijunfu.upload.entity.UploadTaskPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * @Title  : 上传任务分片处理类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 10:19
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public interface UploadTaskPartService extends IService<UploadTaskPart> {

    void uploadPart(MultipartFile file , Long taskId, Integer partIndex) throws IOException;

}
