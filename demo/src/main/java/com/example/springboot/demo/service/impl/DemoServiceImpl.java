package com.example.springboot.demo.service.impl;

import com.example.springboot.core.context.RefrigeratorContext;
import com.example.springboot.demo.domain.RefrigeratorDomain;
import com.example.springboot.demo.domain.RefrigeratorDomainFactory;
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


  private RefrigeratorDomainFactory refrigeratorDomainFactory;

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

    RefrigeratorContext refrigeratorContext = new RefrigeratorContext(req.getName());

    RefrigeratorDomain refrigeratorDomain = refrigeratorDomainFactory.createRefrigeratorDomain();
    //初始化数据
    refrigeratorDomain.initData(refrigeratorContext);
    //找一个空位置
    refrigeratorDomain.findSpace();
    //检查位置是否可用
    refrigeratorDomain.checkRefrigerator();
    //将大象放进冰箱
    refrigeratorDomain.putAnimal();

    refrigeratorDomain.setRefrigerator();

    //发送消息通知
    refrigeratorDomain.sendMsg();

    return AnimalRes.ok(refrigeratorContext);
  }

}
