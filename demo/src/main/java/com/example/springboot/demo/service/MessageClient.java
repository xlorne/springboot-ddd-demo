package com.example.springboot.demo.service;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
public interface MessageClient {

    MsgRes send(MsgReq msgReq);
}
