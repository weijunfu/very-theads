package com.ijunfu.mdc.task;

import com.ijunfu.mdc.util.MdcUtil;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/9 14:49
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class AsyncTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        // 获取当前线程的MDC上下文
        Map<String, String> contextMap = MdcUtil.getCopyOfContextMap();

        return () -> {
            try {
                // 将父线程的MDC上下文设置到子线程中
                if (contextMap != null) {
                    MdcUtil.setContextMap(contextMap);
                }
                runnable.run();
            } finally {
                // 清除子线程中的MDC上下文
                MdcUtil.clear();
            }
        };
    }
}
