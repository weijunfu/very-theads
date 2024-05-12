package com.ijunfu;

import com.ijunfu.common.safe.AESUtil;
import com.ijunfu.common.safe.enums.AESTagLengthEnum;
import com.ijunfu.common.safe.enums.AESTransformationEnum;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/11 23:44
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
public class AESTest {

    @Test
    void test() {

        String content = "{\"name\": \"ijunfu\"}";

        String encrypted = AESUtil.encrypt(
                AESTransformationEnum.GCM,
                "P4wiGBvk6gcLcLGMWAOXPQDnwZqqXLPR",
                content,
                Optional.of(AESTagLengthEnum.L128)
        );
        System.out.println(encrypted);
    }
}
