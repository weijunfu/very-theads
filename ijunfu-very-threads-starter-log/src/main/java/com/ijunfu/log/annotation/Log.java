package com.ijunfu.log.annotation;

import com.ijunfu.log.enums.LogEnum;

import java.lang.annotation.*;

/**
 *
 * @Title  : 日志注解
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/31 10:01
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";

    LogEnum type() default LogEnum.OTHER;

}
