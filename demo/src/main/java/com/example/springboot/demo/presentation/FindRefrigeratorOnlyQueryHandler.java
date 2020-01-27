package com.example.springboot.demo.presentation;

import com.alibaba.cola.presentation.PresentationHandler;
import com.alibaba.cola.presentation.PresentationOnlyQueryHandler;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@PresentationHandler
@AllArgsConstructor
public class FindRefrigeratorOnlyQueryHandler implements PresentationOnlyQueryHandler<Refrigerator> {

    private RefrigeratorQuery refrigeratorQuery;

    @Override
    public Refrigerator query() {
        return refrigeratorQuery.findSpace();
    }
}
