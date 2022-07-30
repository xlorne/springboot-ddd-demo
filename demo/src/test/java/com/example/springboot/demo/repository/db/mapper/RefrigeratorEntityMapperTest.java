package com.example.springboot.demo.repository.db.mapper;

import com.example.springboot.demo.repository.db.entity.RefrigeratorEntity;
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
class RefrigeratorEntityMapperTest {

    @Autowired
    private RefrigeratorEntityMapper refrigeratorEntityMapper;

    @Test
    @Rollback
    void save() {
        RefrigeratorEntity refrigeratorEntity = new RefrigeratorEntity();
        refrigeratorEntity.setValue("123123");
        refrigeratorEntityMapper.save(refrigeratorEntity);
        assertTrue(refrigeratorEntity.getId()>0,"添加数据失败.");
    }

    @Test
    @Rollback
    void updateValue() {
        save();
        RefrigeratorEntity refrigeratorEntity = new RefrigeratorEntity();
        refrigeratorEntity.setValue("!23");
        refrigeratorEntity.setId(1L);
        int res =  refrigeratorEntityMapper.update(refrigeratorEntity);
        assertTrue(res>0,"更新数据失败.");
    }

    @Test
    void truncate() {
        refrigeratorEntityMapper.truncate();
        RefrigeratorEntity refrigeratorEntity =  refrigeratorEntityMapper.findSpace();
        assertTrue(refrigeratorEntity ==null,"清空数据失败");
    }
}