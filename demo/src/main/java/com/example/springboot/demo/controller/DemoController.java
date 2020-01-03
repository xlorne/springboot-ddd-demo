package com.example.springboot.demo.controller;

import com.example.springboot.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/addUser")
    public boolean addUser(@RequestParam("name") String name){
        return demoService.addUser(name);
    }
}
