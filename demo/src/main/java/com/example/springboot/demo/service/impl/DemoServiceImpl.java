package com.example.springboot.demo.service.impl;

import com.alibaba.cola.command.CommandBus;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;
import com.example.springboot.demo.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lorne
 */
@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {


  private CommandBus commandBus;

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
  public AnimalRes put(AnimalReq req) throws Exception {
    return (AnimalRes) commandBus.send(req);
  }

}
