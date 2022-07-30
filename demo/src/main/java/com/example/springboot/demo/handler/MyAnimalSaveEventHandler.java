package com.example.springboot.demo.handler;

import com.codingapi.springboot.framework.handler.Handler;
import com.codingapi.springboot.framework.handler.IHandler;
import com.example.springboot.demo.event.AnimalSaveEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Handler
@AllArgsConstructor
@Slf4j
public class MyAnimalSaveEventHandler implements IHandler<AnimalSaveEvent> {


    @Override
    public void handler(AnimalSaveEvent animalSaveEvent) {
        log.info("多订阅者事件响应测试...,event=>{}",animalSaveEvent);
    }
}
