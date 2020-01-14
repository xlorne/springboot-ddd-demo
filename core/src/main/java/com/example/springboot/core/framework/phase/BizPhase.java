package com.example.springboot.core.framework.phase;

import com.example.springboot.core.framework.BizContext;
import com.example.springboot.core.framework.Observer;
import com.example.springboot.core.framework.step.BizStep;
import java.util.ArrayList;
import java.util.List;

/**
 * 商家阶段步骤
 */
public abstract class BizPhase implements Observer {

  private List<BizStep> steps = new ArrayList<>();

  public void addStep(BizStep step){
    steps.add(step);
  }

  public void delStep(BizStep step){
    steps.remove(step);
  }

  public void notifyStep(BizContext bizContext){
    for(BizStep step:steps){
      step.execute(bizContext);
    }
  }

  @Override
  public void execute(BizContext bizContext) {
      stepBefore(bizContext);
      notifyStep(bizContext);
      stepAfter(bizContext);
  }

  public void stepBefore(BizContext bizContext){}

  public void stepAfter(BizContext bizContext){}

}
