package com.ijunfu.upload.controller;

import com.ijunfu.common.web.response.AjaxResult;
import com.ijunfu.upload.controller.vo.UploadTaskVO;
import com.ijunfu.upload.entity.UploadTask;
import com.ijunfu.upload.service.UploadTaskPartService;
import com.ijunfu.upload.service.UploadTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 10:27
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadTaskController {

    private final UploadTaskService uploadTaskService;

    private final UploadTaskPartService uploadTaskPartService;

    @PostMapping("/task")
    public AjaxResult createTask(@RequestBody UploadTaskVO vo) {

        UploadTask task = uploadTaskService.createTask(vo);
        return AjaxResult.success(AjaxResult.SUCCESS_MSG, task);
    }

    @PostMapping("/part")
    public AjaxResult uploadPart(
            @RequestParam("file")MultipartFile file,
            @RequestParam("id") Long taskId,
            @RequestParam("index") Integer partIndex
            ) {

        try {
            uploadTaskPartService.uploadPart(file, taskId, partIndex);
            return AjaxResult.success(AjaxResult.SUCCESS_MSG);
        } catch (IOException e) {
            log.error("upload error", e);
            return AjaxResult.error(AjaxResult.ERROR_MSG);
        }
    }

    @PutMapping("/merge")
    public String mergePart() {
        return "";
    }

    @GetMapping("/detail")
    public AjaxResult getTaskDetail(@RequestParam("taskId") Long taskId) {
        UploadTask uploadTask = uploadTaskService.getById(taskId);
        return AjaxResult.success(AjaxResult.SUCCESS_MSG, uploadTask);
    }
}
