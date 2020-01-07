package com.example.springboot.demo.service.impl;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.demo.feign.MessageClient;
import com.example.springboot.demo.manager.RefrigeratorManager;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;
import com.example.springboot.demo.service.DemoService;
import org.springframework.transaction.annotation.Transactional;

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

  /**
   * 将大象放进冰箱
   * 1、找到冰箱的有效空间
   * 2、将大象存进冰箱
   * 3、通知消息已存放成功
   *
   * @param req 大象
   * @return  大象所在位置
   */
  @Override
  @Transactional
  public AnimalRes put(AnimalReq req) {
    String name = req.getName();

    //放进大象 对应操作是将大象存到冰箱空间里面
    int id =refrigeratorManager.putAnimal(name);

    //关闭冰箱 对应操作是提交事务，实际本地事务已提交,这里就换成发送一条通知消息
    messageClient.send(MsgReq.create(id,name));

    return AnimalRes.ok(id);
  }
}
