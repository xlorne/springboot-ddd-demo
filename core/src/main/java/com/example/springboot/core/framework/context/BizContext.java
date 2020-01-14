package com.example.springboot.core.framework.context;

import com.example.springboot.core.framework.BizSubjectOperation;
import com.example.springboot.core.framework.phase.BizPhase;
import java.util.HashMap;
import java.util.Map;

public class BizContext{

  private Map<Class<? extends SupportedBizContext>,SupportedBizContext> map = new HashMap<>();

  public void set(SupportedBizContext context){
    if(map.get(context.getClass()) == null) {
      synchronized (BizContext.class) {
        map.putIfAbsent(context.getClass(), context);
      }
    }
  }

  public <T extends SupportedBizContext> T get(Class<T> clazz){
    return (T)map.get(clazz);
  }

  public void operation(BizPhase... phases){
    BizSubjectOperation.operation(this,phases);
  }

}
