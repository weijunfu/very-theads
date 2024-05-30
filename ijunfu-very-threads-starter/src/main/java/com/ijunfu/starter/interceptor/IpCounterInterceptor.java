package com.ijunfu.starter.interceptor;

import com.ijunfu.starter.service.IpCounterService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 17:38
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@RequiredArgsConstructor
public class IpCounterInterceptor implements HandlerInterceptor {

    private final IpCounterService ipCounterService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        ipCounterService.record();

        return Boolean.TRUE;
    }
}
