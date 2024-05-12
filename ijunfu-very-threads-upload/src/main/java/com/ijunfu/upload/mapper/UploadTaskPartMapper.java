package com.ijunfu.upload.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ijunfu.upload.entity.UploadTaskPart;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Title  : 上传任务分片数据处理类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/10 10:15
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Mapper
public interface UploadTaskPartMapper extends BaseMapper<UploadTaskPart> {
}
