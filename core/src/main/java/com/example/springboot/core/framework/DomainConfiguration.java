package com.example.springboot.core.framework;

import com.example.springboot.core.framework.event.Event;
import com.example.springboot.core.framework.event.EventBus;
import com.example.springboot.core.framework.event.Notify;
import com.example.springboot.core.framework.phase.PhaseConstructor;
import com.example.springboot.core.framework.phase.PhaseFactory;
import com.example.springboot.core.framework.step.StepConstructor;
import com.example.springboot.core.framework.step.StepFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DomainConfiguration {


  @Bean
  @ConditionalOnMissingBean
  public StepFactory stepFactory(@Autowired(required = false) List<StepConstructor> stepConstructors){
    return new StepFactory(stepConstructors);
  }

  @Bean
  @ConditionalOnMissingBean
  public PhaseFactory phaseFactory(@Autowired(required = false) List<PhaseConstructor> phaseConstructors){
    return new PhaseFactory(phaseConstructors);
  }

  @Bean
  @ConditionalOnMissingBean
  public EventBus eventBus(@Autowired(required = false) List<Event> events,
      @Autowired(required = false) List<Notify> notifies){
    return new EventBus(events,notifies);
  }

}
