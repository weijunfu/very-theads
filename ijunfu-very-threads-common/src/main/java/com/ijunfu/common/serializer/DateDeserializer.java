package com.ijunfu.common.serializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ijunfu.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 18:14
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
public class DateDeserializer extends StdDeserializer<Date> {

    public DateDeserializer() {
        this(Date.class);
    }

    public DateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        try {
            return DateUtil.stringToDate(jsonParser.getText(), DateUtil.DEFAULT_DATE_PATTERN);
        } catch (ParseException e) {
            log.error("format date error", e);
            throw new RuntimeException(e);
        }
    }
}
