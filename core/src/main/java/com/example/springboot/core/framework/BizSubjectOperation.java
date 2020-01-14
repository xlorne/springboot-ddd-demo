package com.example.springboot.core.framework;

import java.util.List;

public class BizSubjectOperation {


  /**
   * 执行阶段业务
   * @param bizContext  上下文传递对象
   * @param observers   订阅者
   */
  public static void operation(BizContext bizContext,Observer... observers){
    Subject subject = new BizSubject();
    for(Observer observer:observers){
      subject.add(observer);
    }
    subject.operation(bizContext);
  }

  public static void operation(BizContext bizContext,List<Observer> observers){
    Subject subject = new BizSubject();
    for(Observer observer:observers){
      subject.add(observer);
    }
    subject.operation(bizContext);
  }


}
