package com.example.springboot.demo;

import com.alibaba.cola.boot.Bootstrap;
import com.example.springboot.demo.service.InitService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("com.example.springboot.demo.db.mapper")
public class SpringBootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class, args);
  }

  @Autowired
  private InitService initService;

  @PostConstruct
  public void init() {
    initService.init();
  }


  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


  @Bean(initMethod = "init")
  public Bootstrap bootstrap() {
    Bootstrap bootstrap = new Bootstrap();
    List<String> packagesToScan  = new ArrayList<>();
    packagesToScan.add("com.example.springboot.demo");
    bootstrap.setPackages(packagesToScan);
    return bootstrap;
  }

}
