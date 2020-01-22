package com.example.springboot.core.framework.phase;

import com.example.springboot.core.framework.Observer;
import com.example.springboot.core.framework.context.BizContext;
import com.example.springboot.core.framework.step.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * 阶段步骤
 */
public abstract class Phase implements Observer {

  private List<Step> steps = new ArrayList<>();

  public void addStep(Step step){
    steps.add(step);
  }

  public void delStep(Step step){
    steps.remove(step);
  }

  public void notifyStep(BizContext context)throws Exception{
    for(Step step:steps){
      step.execute(context);
    }
  }

  @Override
  public void execute(BizContext context) throws Exception {
      stepBefore(context);
      notifyStep(context);
      stepAfter(context);
  }

  public void stepBefore(BizContext context)throws Exception{}

  public void stepAfter(BizContext context)throws Exception{}

}
