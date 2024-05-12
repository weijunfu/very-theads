package com.ijunfu.common.web.response;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 11:13
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
public final class AjaxResult<T> implements Serializable {

    private static final long serialVersionUID = 121729L;

    private int code;

    private String msg;

    private T data;

    public final static int SUCCESS = 200;
    public final static int ERROR = 500;

    public final static String SUCCESS_MSG = "success";
    public final static String ERROR_MSG = "error";

    private AjaxResult() {
    }

    public AjaxResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private static <T> AjaxResult<T> build(int code, String msg, T t) {
        return new AjaxResult<>(code, msg, t);
    }

    public static <T> AjaxResult<T> success() {
        return build(SUCCESS, SUCCESS_MSG, null);
    }

    public static <T> AjaxResult<T> success(int code) {
        return build(code, SUCCESS_MSG, null);
    }

    public static <T> AjaxResult<T> success(int code, T t) {
        return build(code, SUCCESS_MSG, t);
    }

    public static <T> AjaxResult<T> success(String msg) {
        return build(SUCCESS, msg, null);
    }

    public static <T> AjaxResult<T> success(String msg, T t) {
        return build(SUCCESS, msg, t);
    }

    public static <T> AjaxResult<T> error() {
        return build(ERROR, ERROR_MSG, null);
    }

    public static <T> AjaxResult<T> error(int code) {
        return build(code, ERROR_MSG, null);
    }

    public static <T> AjaxResult<T> error(int code, T t) {
        return build(code, ERROR_MSG, t);
    }

    public static <T> AjaxResult<T> error(String msg) {
        return build(ERROR, msg, null);
    }

    public static <T> AjaxResult<T> error(String msg, T t) {
        return build(ERROR, msg, t);
    }
}
