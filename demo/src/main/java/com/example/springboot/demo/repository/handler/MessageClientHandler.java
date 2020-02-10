package com.example.springboot.demo.repository.handler;

import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.RepositoryHandlerI;
import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import com.example.springboot.demo.repository.feign.MessageClient;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/2/9
 * @description
 */
@AllArgsConstructor
@RepositoryHandler
public class MessageClientHandler implements RepositoryHandlerI {

    private MessageClient messageClient;

    public MsgRes send(MsgReq request) {
        return messageClient.send(request);
    }

}
