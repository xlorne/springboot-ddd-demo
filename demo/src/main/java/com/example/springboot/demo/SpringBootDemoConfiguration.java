package com.example.springboot.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 为什么需要用@Bean而不是直接在代码中加注解，主要是为了将来单元测试编写的方便和将来维护升级的方便，做到可配置化。
 */
@Configuration
public class SpringBootDemoConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


}
