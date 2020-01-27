package com.alibaba.cola.domain;

import com.alibaba.cola.event.EventBus;
import com.alibaba.cola.presentation.PresentationBus;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
public abstract class DomainObject extends EntityObject {

  protected EventBus eventBus;

  protected PresentationBus presentationBus;

  public void initEventBus(EventBus eventBus){
    this.eventBus = eventBus;
  }

  public void initPresentationBus(PresentationBus presentationBus){
    this.presentationBus = presentationBus;
  }

  public abstract void execute();

}
