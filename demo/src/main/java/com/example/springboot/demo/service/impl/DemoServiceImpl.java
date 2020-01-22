package com.example.springboot.demo.service.impl;

import com.example.springboot.core.context.RefrigeratorData;
import com.example.springboot.core.framework.context.BizContext;
import com.example.springboot.core.framework.phase.PhaseFactory;
import com.example.springboot.demo.phase.RefrigeratorPhase;
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

  private PhaseFactory phaseFactory;

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

    RefrigeratorData refrigeratorData = new RefrigeratorData();
    refrigeratorData.setData(req.getName());

    BizContext context = new BizContext();
    context.set(refrigeratorData);

    RefrigeratorPhase refrigeratorPhase = phaseFactory.createPhase(RefrigeratorPhase.class);

    context.execute(refrigeratorPhase);

    return AnimalRes.ok(refrigeratorData);
  }

}
