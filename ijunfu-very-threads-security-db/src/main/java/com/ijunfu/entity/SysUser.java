package com.ijunfu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/15 13:38
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    private String username;

    @JsonIgnore
    private String password;

    private Boolean enabled;

}
