package com.example.springboot.core.framework;

import com.example.springboot.core.framework.context.BizContext;

public interface Observer {

  /**
   * 观察者执行业务
   * @param context  观察者全局对象
   */
  void execute(BizContext context) throws Exception;

}
