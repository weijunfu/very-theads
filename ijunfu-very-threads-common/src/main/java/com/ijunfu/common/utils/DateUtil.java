package com.ijunfu.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/12 18:08
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public final class DateUtil {
    private DateUtil(){}

    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static SimpleDateFormat getDateFormat(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat;
    }

    public static String dateToString(Date date, String pattern) {
        return getDateFormat(pattern).format(date);
    }

    public static Date stringToDate(String dateStr, String pattern) throws ParseException {
        return getDateFormat(pattern).parse(dateStr);
    }
}
