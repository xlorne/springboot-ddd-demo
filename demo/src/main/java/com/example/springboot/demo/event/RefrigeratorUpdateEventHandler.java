package com.example.springboot.demo.event;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@EventHandler
@AllArgsConstructor
public class RefrigeratorUpdateEventHandler implements EventHandlerI<Response,Refrigerator> {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public Response execute(Refrigerator refrigerator) {
        refrigeratorMapper.updateValue(refrigerator);
        return Response.buildSuccess();
    }
}
