package com.example.springboot.core.framework.context;

import com.example.springboot.core.framework.BizSubjectOperation;
import com.example.springboot.core.framework.Observer;
import com.example.springboot.core.framework.phase.Phase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BizContext全局对象
 */
public class BizContext  {

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

  public void execute(Phase... phases)throws Exception{
    BizSubjectOperation.execute(this,phases);
  }

  public void execute(Observer... observers)throws Exception{
    BizSubjectOperation.execute(this,observers);
  }

  public void execute(List<Observer> phases)throws Exception{
    BizSubjectOperation.execute(this,phases);
  }


}
