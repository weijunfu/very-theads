package com.ijunfu.mdc.config;

import com.ijunfu.mdc.task.AsyncTaskDecorator;
import com.ijunfu.mdc.util.Contents;
import com.ijunfu.mdc.util.MdcUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/9 14:11
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean(Contents.ASYNC_TASK_NAME)
    public Executor asyncExecutor() {
        int processors = Runtime.getRuntime().availableProcessors();

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(processors + 1);
        executor.setMaxPoolSize(processors << 1);
        executor.setQueueCapacity(processors << 1);
        executor.setThreadNamePrefix(Contents.ASYNC_TASK_PREFIX);
        executor.setTaskDecorator(new AsyncTaskDecorator());
        executor.initialize();

        return executor;
    }
}
