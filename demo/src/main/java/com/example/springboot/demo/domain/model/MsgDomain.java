package com.example.springboot.demo.domain.model;

import com.alibaba.cola.domain.DomainObject;
import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import com.example.springboot.demo.repository.handler.MessageClientHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Slf4j
public class MsgDomain extends DomainObject {

    private final MsgReq msgReq;

    public MsgDomain(Long refrigeratorId, String data) {
        this.msgReq = new MsgReq(refrigeratorId,data);
    }

    public void sendMsg(){
        MsgRes msgRes = repository(MessageClientHandler.class).send(msgReq);
        log.info("send msg=>{}",msgRes);

    }

}
