package com.example.springboot.demo;

import com.example.springboot.demo.feign.MessageClient;
import com.example.springboot.demo.manager.RefrigeratorManager;
import com.example.springboot.demo.service.DemoService;
import com.example.springboot.demo.service.impl.DemoServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 为什么需要用@Bean而不是直接在代码中加注解，主要是为了将来单元测试编写的方便和将来维护升级的方便，做到可配置化。
 */
@Configuration
public class SpringbootDemoConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  @ConditionalOnMissingBean
  public DemoService demoService(RefrigeratorManager refrigeratorManager,
      MessageClient messageClient) {
    return new DemoServiceImpl(refrigeratorManager, messageClient);
  }

}
