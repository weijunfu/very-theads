package com.ijunfu.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ijunfu.common.serializer.DateDeserializer;
import com.ijunfu.common.serializer.DateSerializer;
import com.ijunfu.common.serializer.LongDeserializer;
import com.ijunfu.common.serializer.LongSerializer;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 17:49
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public final class JsonUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());

        SimpleModule customModule = new SimpleModule();

        customModule.addSerializer(Date.class, new DateSerializer());
        customModule.addDeserializer(Date.class, new DateDeserializer());

        customModule.addSerializer(Long.class, new LongSerializer());
        customModule.addDeserializer(Long.class, new LongDeserializer());

        objectMapper.registerModule(customModule);
    }

    private JsonUtil() {}

    /**
     * 将Java对象转换为Json字符串
     *
     * @param object 待转换的对象
     * @return Json字符串
     * @throws IOException 如果转换过程中发生错误
     */
    public static String toJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * 将Json字符串反序列化为Java对象
     *
     * @param jsonString Json字符串
     * @param clazz 目标对象的Class类型
     * @param <T> 泛型类型
     * @return 反序列化的Java对象
     * @throws IOException 如果反序列化过程中发生错误
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonString, clazz);
    }

    /**
     * 将Json字符串反序列化为Map对象
     *
     * @param jsonString Json字符串
     * @return 反序列化的Map对象
     * @throws IOException 如果反序列化过程中发生错误
     */
    public static Map<String, Object> toMap(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});
    }
}
