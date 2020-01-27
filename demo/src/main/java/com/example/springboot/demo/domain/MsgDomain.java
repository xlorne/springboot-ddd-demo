package com.example.springboot.demo.domain;

import com.alibaba.cola.domain.DomainObject;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Slf4j
public class MsgDomain extends DomainObject {

    private Long refrigeratorId;
    private String data;

    public MsgDomain(Long refrigeratorId, String data) {
        this.refrigeratorId = refrigeratorId;
        this.data = data;
    }

    @Override
    public void execute() {
        sendMsg();
    }

    public void sendMsg(){
        MsgReq msgReq = new MsgReq(refrigeratorId,data);
        MsgRes msgRes = (MsgRes) repositoryBus.query(msgReq);
        log.info("send msg=>{}",msgRes);
    }
}
