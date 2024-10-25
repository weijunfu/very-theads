package com.ijunfu.pdf.mapper;

import com.ijunfu.pdf.PdfApplication;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ijunfu
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest(classes = PdfApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentMapperTest {

    @Test
    void connection(@Autowired SqlSessionFactory sqlSessionFactory) {
        log.info("{}", sqlSessionFactory);
        assertNotNull(sqlSessionFactory);
    }

    @Test
    void findAll(@Autowired StudentMapper studentMapper) {
        log.info("{}", studentMapper.selectList(null));
    }

}