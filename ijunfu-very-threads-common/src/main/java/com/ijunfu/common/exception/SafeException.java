package com.ijunfu.common.exception;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 17:43
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class SafeException extends RuntimeException {

    public SafeException() {
    }

    public SafeException(String message) {
        super(message);
    }

    public SafeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SafeException(Throwable cause) {
        super(cause);
    }

    public SafeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
