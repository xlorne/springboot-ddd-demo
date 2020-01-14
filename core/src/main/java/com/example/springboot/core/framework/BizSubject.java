package com.example.springboot.core.framework;

import com.example.springboot.core.framework.context.BizContext;

public class BizSubject extends AbstractSubject {

  @Override
  public void operation(BizContext bizContext) {
      notifyObservers(bizContext);
  }

}
