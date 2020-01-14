package com.example.springboot.demo;

import com.example.springboot.demo.service.InitService;
import javax.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.springboot.demo.db.mapper")
@SpringBootApplication
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


}
