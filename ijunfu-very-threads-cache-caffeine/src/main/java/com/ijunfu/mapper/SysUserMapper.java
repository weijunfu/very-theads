package com.ijunfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ijunfu.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Title  : 系统用户数据操作
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/17 12:39
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
