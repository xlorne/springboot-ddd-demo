package com.example.springboot.demo.event.handler;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EventHandler
@AllArgsConstructor
@Slf4j
public class MyAnimalSaveEventHandler implements EventHandlerI<Response, AnimalSaveEvent> {

    @Override
    public Response execute(AnimalSaveEvent animalSaveEvent) {
        log.info("多订阅者事件响应测试...,event=>{}",animalSaveEvent);
        return Response.buildSuccess();
    }

}
