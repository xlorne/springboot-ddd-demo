package com.example.springboot.demo.feign;

import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class MessageClient {

    private final RestTemplate restTemplate;

    public MsgRes send(MsgReq msgReq) {
        return restTemplate.postForObject("http://127.0.0.1:8088/send", msgReq, MsgRes.class);
    }
}
