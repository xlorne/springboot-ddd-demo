package com.example.springboot.core.framework;

public interface Observer {

  /**
   * 观察者执行业务
   * @param bizContext  观察者全局对象
   */
  void execute(BizContext bizContext);

}
