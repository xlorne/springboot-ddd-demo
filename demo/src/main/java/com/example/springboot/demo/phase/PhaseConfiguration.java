package com.example.springboot.demo.phase;

import com.example.springboot.core.framework.phase.PhaseConstructor;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@AllArgsConstructor
public class PhaseConfiguration {

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
