package com.example.springboot.demo.domain;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.event.EventBus;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
public abstract class DomainObject extends EntityObject {

  EventBus eventBus;

  public void initEventBus(EventBus eventBus){
    this.eventBus = eventBus;
  }

  public abstract void execute();

}
