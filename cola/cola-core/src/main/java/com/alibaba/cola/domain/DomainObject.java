package com.alibaba.cola.domain;

import com.alibaba.cola.event.EventBus;
import com.alibaba.cola.repository.RepositoryBus;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
public abstract class DomainObject extends EntityObject {

  protected EventBus eventBus;

  protected RepositoryBus repositoryBus;

  public void initEventBus(EventBus eventBus){
    this.eventBus = eventBus;
  }

  public void initPresentationBus(RepositoryBus repositoryBus){
    this.repositoryBus = repositoryBus;
  }

  public abstract void execute();

}
