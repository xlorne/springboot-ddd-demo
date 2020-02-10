package com.example.springboot.demo.domain.model;

import com.alibaba.cola.domain.DomainObject;
import com.alibaba.cola.executor.Step;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.repository.handler.MessageClientHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Slf4j
@Step
public class MsgDomain extends DomainObject {

    private final Long refrigeratorId;
    private final String data;

    public MsgDomain(Long refrigeratorId, String data) {
        this.refrigeratorId = refrigeratorId;
        this.data = data;
    }


    public void sendMsg(){
        MsgReq msgReq = new MsgReq(refrigeratorId,data);
        MsgRes msgRes = repository(MessageClientHandler.class).send(msgReq);
        log.info("send msg=>{}",msgRes);

    }

}
