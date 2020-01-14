package com.example.springboot.core.framework.phase;

public interface PhaseConstructor<T extends BizPhase> {

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
