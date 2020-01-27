package com.example.springboot.demo.presentation;

import com.alibaba.cola.presentation.PresentationHandler;
import com.alibaba.cola.presentation.PresentationQueryHandler;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@PresentationHandler
@AllArgsConstructor
public class SendMsgQueryHandler implements PresentationQueryHandler<MsgReq,MsgRes> {

    private MessageClient messageClient;

    @Override
    public MsgRes query(MsgReq request) {
        return messageClient.send(request);
    }
}
