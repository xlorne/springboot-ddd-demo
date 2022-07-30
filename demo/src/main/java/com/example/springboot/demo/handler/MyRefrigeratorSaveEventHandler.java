package com.example.springboot.demo.handler;

import com.codingapi.springboot.framework.handler.Handler;
import com.codingapi.springboot.framework.handler.IHandler;
import com.example.springboot.demo.event.RefrigeratorSaveEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Handler
@AllArgsConstructor
@Slf4j
public class MyRefrigeratorSaveEventHandler implements IHandler<RefrigeratorSaveEvent> {


    @Override
    public void handler(RefrigeratorSaveEvent refrigeratorSaveEvent) {
        log.info("多订阅者事件响应测试...,event=>{}", refrigeratorSaveEvent);
    }
}
