package com.example.springboot.demo.repository.db.mapper;

import com.example.springboot.demo.repository.db.domain.Refrigerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class RefrigeratorMapperTest {

    @Autowired
    private RefrigeratorMapper refrigeratorMapper;

    @Test
    @Rollback
    void save() {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setValue("123123");
        refrigeratorMapper.save(refrigerator);
        assertTrue(refrigerator.getId()>0,"添加数据失败.");
    }

    @Test
    @Rollback
    void updateValue() {
        save();
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setValue("!23");
        refrigerator.setId(1L);
        int res =  refrigeratorMapper.update(refrigerator);
        assertTrue(res>0,"更新数据失败.");
    }

    @Test
    void truncate() {
        refrigeratorMapper.truncate();
        Refrigerator refrigerator =  refrigeratorMapper.findSpace();
        assertTrue(refrigerator==null,"清空数据失败");
    }
}