package com.ijunfu.mdc.service;

import com.ijunfu.mdc.util.Contents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 23:57
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Async(Contents.ASYNC_TASK_NAME)
    public void asyncTask() {
        try {
            Thread.sleep(1000);
            log.info("async task...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
