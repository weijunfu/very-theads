package com.ijunfu.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ijunfu.common.safe.AESUtil;
import com.ijunfu.common.safe.enums.AESTagLengthEnum;
import com.ijunfu.common.safe.enums.AESTransformationEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 22:31
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@ControllerAdvice
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice {

    private static final String RAW_DATA = "raw";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setTimeZone(TimeZone.getDefault());
    }

    @Value("${server.key}")
    private String key;

    @Value("${server.secret: true}")
    private Boolean secret;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(Boolean.TRUE.equals(secret)) {

            try {
                log.info("response body: {}", body);
                String responseBody = objectMapper.writeValueAsString(body);
                Map<String, String> map = new HashMap<>();
                map.put(RAW_DATA,
                        AESUtil.encrypt(
                                AESTransformationEnum.GCM,
                                key,
                                responseBody,
                                Optional.of(AESTagLengthEnum.L128)
                        )
                );

                return map;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }

        return body;
    }
}
