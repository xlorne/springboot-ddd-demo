package com.example.springboot.core.framework;

public class BizSubject extends AbstractSubject {

  @Override
  public void operation(BizContext bizContext) {
      notifyObservers(bizContext);
  }

}
