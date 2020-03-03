package com.example.springboot.demo.repository.feign;

import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MessageClient {

    @Autowired
    private RestTemplate restTemplate;

    public MsgRes send(MsgReq msgReq) {
        return restTemplate.postForObject("http://127.0.0.1:8088/send", msgReq, MsgRes.class);
    }
}
