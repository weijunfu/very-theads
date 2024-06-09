package com.ijunfu.mdc.util;

import org.slf4j.MDC;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 22:35
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public final class MdcUtil {

    private MdcUtil(){}

    public static final String MDC_KEY = "traceId";
    public static final String MDC_TS = "ts";

    public static void put() {
        putTraceId(NanoId.randomNanoId());
        putTs();
    }

    public static void putTraceId(String value) {
        put(MDC_KEY, value);
    }

    public static void putTs() {
        put(MDC_TS, String.valueOf(new Date().getTime()));
    }

    public static void putTs(String value) {
        put(MDC_TS, value);
    }

    public static void put(String key, String value) {
        MDC.put(key, value);
    }

    public static void clear() {
        MDC.clear();
    }

    public static Map<String, String> getCopyOfContextMap() {
        return MDC.getCopyOfContextMap();
    }

    public static void setContextMap(Map<String, String> contextMap) {
        MDC.setContextMap(contextMap);
    }

    private static void initContextMap() {


    }

    public static <V> Callable<V> wrap(Callable<V> callable) {
        Map<String, String> contextMap = getCopyOfContextMap();

        return () -> {

            if(Objects.nonNull(contextMap)) {
                setContextMap(contextMap);
            }

            try {
                return callable.call();
            } finally {
                clear();    // 清除MDC，避免内存泄漏和混淆
            }

        };
    }

    public static Runnable wrap(Runnable runnable) {
        Map<String, String> contextMap = getCopyOfContextMap();

        return () -> {

            if(Objects.nonNull(contextMap)) {
                setContextMap(contextMap);
            }

            try {
                runnable.run();
            } finally {
                clear();    // 清除MDC，避免内存泄漏和混淆
            }
        };
    }
}
