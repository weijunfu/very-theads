package com.ijunfu.mapper;

import com.ijunfu.common.utils.JsonUtil;
import com.ijunfu.entity.SysUser;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/15 13:52
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SysUserMapperTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void selectList() throws IOException {
        List<SysUser> list = sysUserMapper.selectList(null);

        log.info("list: {}", JsonUtil.toJson(list));
    }
}