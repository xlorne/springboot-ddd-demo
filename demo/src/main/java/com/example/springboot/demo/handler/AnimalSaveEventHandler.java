package com.example.springboot.demo.handler;

import com.codingapi.springboot.framework.handler.Handler;
import com.codingapi.springboot.framework.handler.IHandler;
import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import com.example.springboot.demo.event.AnimalSaveEvent;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Handler
@AllArgsConstructor
@Slf4j
public class AnimalSaveEventHandler implements IHandler<AnimalSaveEvent> {

    private MessageClient messageClient;

    @Override
    public void handler(AnimalSaveEvent event) {
        MsgRes msgRes = messageClient.send(new MsgReq(event.getRefrigeratorId(), event.getName()));
        log.info("accept:msg=>{}", msgRes);
    }
}
