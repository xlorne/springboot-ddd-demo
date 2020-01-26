package com.example.springboot.demo.event;

import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@EventHandler
@AllArgsConstructor
public class SendMsgEventHandler implements EventHandlerI<MsgRes, MsgReq> {

    private MessageClient messageClient;

    @Override
    public MsgRes execute(MsgReq msgReq) {
        return messageClient.send(msgReq);
    }
}
