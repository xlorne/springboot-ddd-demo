package com.example.springboot.core.framework;

import com.example.springboot.core.framework.context.BizContext;

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

}
