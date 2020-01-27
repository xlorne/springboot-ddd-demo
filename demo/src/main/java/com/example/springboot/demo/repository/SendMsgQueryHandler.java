package com.example.springboot.demo.repository;

import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.RepositoryQueryHandler;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@RepositoryHandler
@AllArgsConstructor
public class SendMsgQueryHandler implements RepositoryQueryHandler<MsgRes,MsgReq> {

    private MessageClient messageClient;

    @Override
    public MsgRes query(MsgReq request) {
        return messageClient.send(request);
    }
}
