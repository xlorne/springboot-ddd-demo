package com.example.springboot.demo.service.impl;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.demo.domain.Log;
import com.example.springboot.demo.domain.User;
import com.example.springboot.demo.service.DemoService;
import com.example.springboot.demo.service.LogService;
import com.example.springboot.demo.service.MessageClient;
import com.example.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @Autowired
    private MessageClient messageClient;


    @Override
    @Transactional
    public boolean addUser(String name) {
        //保存用户
        User user = new User();
        user.setName(name);
        userService.save(user);
        //保存日志
        Log log = new Log();
        log.setName(name);
        log.setTime(new Date());
        logService.save(log);
        //传递消息通知
        MsgReq msgReq = new MsgReq();
        msgReq.setData(name);
        messageClient.send(msgReq);
        return true;
    }
}
