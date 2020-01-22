package com.example.springboot.core.framework;

import com.example.springboot.core.framework.context.BizContext;

import java.util.List;

public class BizSubjectOperation {

  /**
   * 执行阶段业务
   * @param bizContext  上下文传递对象
   * @param observers   订阅者
   */
  public static void execute(BizContext bizContext,Observer... observers)throws Exception{
    Subject subject = new BizSubject();
    for(Observer observer:observers){
      subject.add(observer);
    }
    subject.operation(bizContext);
  }

  public static void execute(BizContext bizContext,List<Observer> observers)throws Exception{
    Subject subject = new BizSubject();
    for(Observer observer:observers){
      subject.add(observer);
    }
    subject.operation(bizContext);
  }


}
