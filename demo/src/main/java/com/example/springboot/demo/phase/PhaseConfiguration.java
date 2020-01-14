package com.example.springboot.demo.phase;

import com.example.springboot.core.framework.phase.PhaseConstructor;
import com.example.springboot.core.framework.phase.PhaseFactory;
import com.example.springboot.core.framework.step.StepConstructor;
import com.example.springboot.core.framework.step.StepFactory;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import com.example.springboot.demo.feign.MessageClient;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class PhaseConfiguration {


  @Bean
  @Autowired(required = false)
  public PhaseFactory phaseFactory(List<PhaseConstructor> phaseConstructors){
    return new PhaseFactory(phaseConstructors);
  }

  @Bean
  @Autowired(required = false)
  public StepFactory stepFactory(List<StepConstructor> stepConstructors){
    return new StepFactory(stepConstructors);
  }


  @Configuration
  @AllArgsConstructor
  class PhaseConstructorConfiguration{

    private MessageClient messageClient;
    private RefrigeratorQuery refrigeratorQuery;
    private RefrigeratorMapper refrigeratorMapper;

    @Component
    class RefrigeratorPhaseConstructor implements PhaseConstructor<RefrigeratorPhase> {

      @Override
      public RefrigeratorPhase constructor() {
        return new RefrigeratorPhase(refrigeratorMapper,refrigeratorQuery,messageClient);
      }

      @Override
      public Class<RefrigeratorPhase> getType() {
        return RefrigeratorPhase.class;
      }
    }
  }



}
