package com.ijunfu.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijunfu.common.exception.SafeException;
import com.ijunfu.common.safe.AESUtil;
import com.ijunfu.common.safe.enums.AESTagLengthEnum;
import com.ijunfu.common.safe.enums.AESTransformationEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 21:52
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@ControllerAdvice
public class DecodeRequestBodyAdvice implements RequestBodyAdvice {

    private static final String RAW_DATA = "raw";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${server.key}")
    private String key;

    @Value("${server.secret: true}")
    private Boolean secret;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        if(Boolean.TRUE.equals(secret)) {
            return new DecodeHttpInputMessage(inputMessage);
        }

        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    class DecodeHttpInputMessage implements HttpInputMessage {

        private HttpHeaders headers;

        private InputStream body;

        public DecodeHttpInputMessage(HttpInputMessage httpInputMessage) throws IOException {
            this.headers = httpInputMessage.getHeaders();

            String srcBody = decrypt(IOUtils.toString(httpInputMessage.getBody(), StandardCharsets.UTF_8));

            this.body = IOUtils.toInputStream(srcBody, StandardCharsets.UTF_8);
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }

        private String decrypt(String requestData) throws JsonProcessingException {
            log.info("request encode body: {}", requestData);

            if(Objects.isNull(requestData) || requestData.isEmpty() || !StringUtils.hasText(requestData)) {
                return requestData;
            }

            Map<String, Object> map =
                    objectMapper.readValue(
                            requestData,
                            new TypeReference<Map<String, Object>>() {}
                    );

            log.info("{}", map);

            if(!map.containsKey(RAW_DATA)) {

                if(secret) {
                    // 开启加密时，请求参数应该被加密
                    throw new SafeException("Access parameter exception");
                }

                return requestData;
            }

            String data = map.getOrDefault(RAW_DATA, "").toString();

            try {
                String content = AESUtil.decrypt(
                        AESTransformationEnum.GCM, key, data, Optional.of(AESTagLengthEnum.L128)
                );
                log.info("request decode body: {}", content);

                return content;
            } catch (SafeException ex) {
                log.error("解密请求参数失败", ex);
                throw new SafeException(ex);
            }
        }
    }
}
