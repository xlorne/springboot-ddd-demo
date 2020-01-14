package com.example.springboot.core.framework.step;

public interface StepConstructor<T extends BizStep> {

  /**
   * 创建对象
   * @return
   */
  T constructor();

  /**
   * 获取类型
   * @return
   */
  Class<T> getType();

}
