package com.example.springboot.demo;

import com.example.springboot.demo.manager.RefrigeratorManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@MapperScan("com.example.springboot.demo.manager.mapper")
@SpringBootApplication
public class SpringbootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootDemoApplication.class, args);
  }

  @Autowired
  private RefrigeratorManager refrigeratorManager;

  @PostConstruct
  public void init() {
    refrigeratorManager.init();
  }


}
