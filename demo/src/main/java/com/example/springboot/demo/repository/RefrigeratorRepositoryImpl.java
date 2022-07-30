package com.example.springboot.demo.repository;

import com.codingapi.springboot.framework.convert.BeanConvertor;
import com.example.springboot.demo.domain.Refrigerator;
import com.example.springboot.demo.domain.RefrigeratorRepository;
import com.example.springboot.demo.repository.db.entity.RefrigeratorEntity;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RefrigeratorRepositoryImpl implements RefrigeratorRepository {

    private final RefrigeratorEntityMapper refrigeratorEntityMapper;

    @Override
    public Refrigerator loadSpace() {
        RefrigeratorEntity entity =  refrigeratorEntityMapper.findSpace();
        return BeanConvertor.convert(entity,Refrigerator.class);
    }

    @Override
    public void update(Refrigerator refrigerator) {
        RefrigeratorEntity entity = BeanConvertor.convert(refrigerator,RefrigeratorEntity.class);
        refrigeratorEntityMapper.update(entity);
    }

    @Override
    public void truncate() {
        refrigeratorEntityMapper.truncate();
    }

    @Override
    public void save(Refrigerator refrigerator) {
        RefrigeratorEntity entity = BeanConvertor.convert(refrigerator,RefrigeratorEntity.class);
        refrigeratorEntityMapper.save(entity);
    }
}
