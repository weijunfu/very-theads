package com.ijunfu.enable.interceptor;

import com.ijunfu.enable.config.ShowInfoConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Title :
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 20:03
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@Slf4j
@RequiredArgsConstructor
public class MyInterceptor implements HandlerInterceptor {

    private final ShowInfoConfiguration showInfoConfiguration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("my interceptor...");
        if(showInfoConfiguration.getEnable()) {
            String info = showInfoConfiguration.getInfo();
            if(StringUtils.hasText(info)) {
                log.info("{}", info);
            } else {
                log.info("Hello, ijunfu...");
            }
        } else {
            log.info("未开启...");
        }

        return Boolean.TRUE;
    }
}
