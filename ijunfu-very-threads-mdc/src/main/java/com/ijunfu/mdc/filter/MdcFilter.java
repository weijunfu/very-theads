package com.ijunfu.mdc.filter;

import com.ijunfu.mdc.util.MdcUtil;
import com.ijunfu.mdc.util.NanoId;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * title  : 
 * author : ijunfu <ijunfu@163.com>
 * date   : 2024/6/8 22:33
 * version: 1.0
 * motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class MdcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String traceId = httpServletRequest.getHeader("traceId");
            if(Objects.isNull(traceId)) {
                traceId = NanoId.randomNanoId();
            }

            MdcUtil.putTraceId(traceId);
            MdcUtil.putTs();

            log.info("{}", httpServletRequest.getRequestURI());

            chain.doFilter(request, response);
        } finally {
            MdcUtil.clear();    // 清除MDC信息，避免内存泄漏和混淆
        }
    }
}
