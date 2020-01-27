package com.example.springboot.demo.presentation;

import com.alibaba.cola.presentation.PresentationCommandHandler;
import com.alibaba.cola.presentation.PresentationHandler;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.presentation.dto.RefrigeratorUpdate;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@PresentationHandler
@AllArgsConstructor
public class RefrigeratorUpdateCommandHandler implements PresentationCommandHandler<RefrigeratorUpdate> {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public void command(RefrigeratorUpdate refrigeratorUpdate) {
        refrigeratorMapper.updateValue(refrigeratorUpdate.getRefrigerator());
    }
}
