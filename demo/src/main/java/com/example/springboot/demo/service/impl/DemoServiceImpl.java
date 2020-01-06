package com.example.springboot.demo.service.impl;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.demo.feign.MessageClient;
import com.example.springboot.demo.manager.RefrigeratorManager;
import com.example.springboot.demo.manager.domain.Refrigerator;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;
import com.example.springboot.demo.service.DemoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author lorne
 */
public class DemoServiceImpl implements DemoService {

    private RefrigeratorManager refrigeratorManager;

    private MessageClient messageClient;


    public DemoServiceImpl(RefrigeratorManager refrigeratorManager, MessageClient messageClient) {
        this.refrigeratorManager = refrigeratorManager;
        this.messageClient = messageClient;
    }

    @Override
    @Transactional
    public AnimalRes put(AnimalReq req) {
        String name = req.getName();
        //打开冰箱 对应操作是找到一个存储大象的空间
        Refrigerator refrigerator = refrigeratorManager.findSpace();

        //放进大象 对应操作是将大象存到冰箱空间里面
        refrigeratorManager.putAnimal(refrigerator.getId(),name);

        //关闭冰箱 对应操作是提交事务，实际本地事务已提交,这里就换成发送一条通知消息
        messageClient.send(MsgReq.create(String.format("%s->id:%d",name,refrigerator.getId())));

        return new AnimalRes(refrigerator.getId(),new Date());
    }
}
