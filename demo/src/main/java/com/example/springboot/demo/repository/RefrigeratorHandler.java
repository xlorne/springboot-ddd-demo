package com.example.springboot.demo.repository;

import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.RepositoryHandlerI;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import com.example.springboot.demo.repository.dto.RefrigeratorFindSpace;
import com.example.springboot.demo.repository.dto.RefrigeratorUpdate;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@RepositoryHandler
@AllArgsConstructor
public class RefrigeratorHandler implements RepositoryHandlerI {

    private RefrigeratorMapper refrigeratorMapper;

    private RefrigeratorQuery refrigeratorQuery;

    public void update(RefrigeratorUpdate refrigeratorUpdate) {
        refrigeratorMapper.updateValue(refrigeratorUpdate.getRefrigerator());
    }

    public Refrigerator findSpace(RefrigeratorFindSpace refrigeratorFindSpace){
        return refrigeratorQuery.findSpace();
    }

}
