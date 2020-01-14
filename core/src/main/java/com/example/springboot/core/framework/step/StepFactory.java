package com.example.springboot.core.framework.step;

import java.util.List;

/**
 * 步骤工厂
 * 创建步骤对象
 */
public class StepFactory {

  private List<StepConstructor> constructors;

  public StepFactory(
      List<StepConstructor> constructors) {
    this.constructors = constructors;
  }

  /**
   * 创建阶段
   * @param clazz 阶段类型
   * @param <T>   阶段泛型
   * @return      阶段对象
   */
  public <T> T createStep(Class<T> clazz){
    if(constructors!=null) {
      for (StepConstructor constructor : constructors) {
        if (constructor.getType().equals(clazz)) {
          return (T) constructor.constructor();
        }
      }
    }
    return null;
  }

}
