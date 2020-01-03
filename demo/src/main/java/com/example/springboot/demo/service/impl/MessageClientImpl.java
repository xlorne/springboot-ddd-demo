package com.example.springboot.demo.service.impl;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.service.MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Service
public class MessageClientImpl implements MessageClient {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MsgRes send(MsgReq msgReq) {
        return restTemplate.postForObject("http://127.0.0.1:8088/send",msgReq, MsgRes.class);
    }
}
