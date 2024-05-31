package com.ijunfu.log.aspect;

import com.ijunfu.log.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @Title  : 日志切面
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/31 9:53
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Aspect
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(log)")
    public void webLog(Log log) {}

    /**
     * @Title  : 在方法执行之前执行
     *
     * @Param	: joinPoint
	 * @Param	: log
     * @Return : void
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/31 10:11
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Before("@annotation(log)")
    public void doBefore(JoinPoint joinPoint, Log log) {
        logger.info("before-> {} {}", log.type().getDesc(), log.value());
    }

    /**
     * @Title  : 在方法执行之后执行
     *
     * @Param	: joinPoint
	 * @Param	: log
     * @Return : void
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/31 10:11
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @After("@annotation(log)")
    public void doAfter(JoinPoint joinPoint, Log log) {
        logger.info(" after-> {} {}", log.type().getDesc(), log.value());
    }
}
