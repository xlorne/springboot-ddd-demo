package com.example.springboot.demo.controller;

import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;
import com.example.springboot.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller 层完成对数据的检查,调用Service层
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;


    @PostMapping("/put")
    public AnimalRes put(@Validated @RequestBody AnimalReq animalReq) throws Exception {
        return demoService.put(animalReq);
    }
}
