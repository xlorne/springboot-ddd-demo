package com.example.springboot.demo.event;

import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.event.EventI;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@EventHandler
@AllArgsConstructor
public class FindRefrigeratorEventHandler implements EventHandlerI<Refrigerator, FindRefrigeratorEventHandler.FindRefrigeratorEvent>{

    private RefrigeratorQuery refrigeratorQuery;

    @Override
    public Refrigerator execute(FindRefrigeratorEvent aVoid){
        return refrigeratorQuery.findSpace();
    }

    public static class FindRefrigeratorEvent implements EventI {

    }

}
