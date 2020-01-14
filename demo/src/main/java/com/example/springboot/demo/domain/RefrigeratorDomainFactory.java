package com.example.springboot.demo.domain;

import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefrigeratorDomainFactory {

  private RefrigeratorMapper refrigeratorMapper;

  private RefrigeratorQuery refrigeratorQuery;

  private MessageClient messageClient;


  public RefrigeratorDomain createRefrigeratorDomain(){
      return new RefrigeratorDomain(refrigeratorMapper,refrigeratorQuery,messageClient);
  }

}
