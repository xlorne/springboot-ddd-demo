package com.example.springboot.demo.repository;

import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.PresentationOnlyQueryHandler;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@RepositoryHandler
@AllArgsConstructor
public class FindRefrigeratorOnlyQueryHandler implements PresentationOnlyQueryHandler<Refrigerator> {

    private RefrigeratorQuery refrigeratorQuery;

    @Override
    public Refrigerator query() {
        return refrigeratorQuery.findSpace();
    }
}
