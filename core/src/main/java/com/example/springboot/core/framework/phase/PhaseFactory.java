package com.example.springboot.core.framework.phase;

import java.util.List;

/**
 * 阶段阶段工厂
 * 创建阶段对象，执行步骤
 */
public class PhaseFactory {

  private List<PhaseConstructor> constructors;

  public PhaseFactory(
      List<PhaseConstructor> constructors) {
    this.constructors = constructors;
  }

  /**
   * 创建阶段
   * @param clazz 阶段类型
   * @param <T>   阶段泛型
   * @return      阶段对象
   */
  public <T> T createPhase(Class<T> clazz){
    if(constructors!=null) {
      for (PhaseConstructor constructor : constructors) {
        if (constructor.getType().equals(clazz)) {
          return (T) constructor.constructor();
        }
      }
    }
    return null;
  }

}
