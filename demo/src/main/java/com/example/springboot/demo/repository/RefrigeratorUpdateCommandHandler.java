package com.example.springboot.demo.repository;

import com.alibaba.cola.repository.RepositoryCommandHandler;
import com.alibaba.cola.repository.RepositoryHandler;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.repository.dto.RefrigeratorUpdate;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@RepositoryHandler
@AllArgsConstructor
public class RefrigeratorUpdateCommandHandler implements RepositoryCommandHandler<RefrigeratorUpdate> {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public void command(RefrigeratorUpdate refrigeratorUpdate) {
        refrigeratorMapper.updateValue(refrigeratorUpdate.getRefrigerator());
    }
}
