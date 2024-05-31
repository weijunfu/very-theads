package com.ijunfu.log.enums;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/31 11:55
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public enum LogEnum {

    INSERT("insert", "新增"),

    UPDATE("update", "修改"),

    DELETE("delete", "删除"),

    QUERY("query", "查询"),

    EXPORT("export", "导出"),

    IMPORT("import", "导入"),

    OTHER("other", "其他");

    private String code;

    private String desc;

    LogEnum(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
