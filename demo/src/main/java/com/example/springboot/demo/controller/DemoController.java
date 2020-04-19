package com.example.springboot.demo.controller;

import com.alibaba.cola.dto.SingleResponse;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.service.AnimalCenterService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller 层完成对数据的检查,调用Service层
 */
@RestController
@AllArgsConstructor
public class DemoController {

    private AnimalCenterService animalCenterService;

    @PostMapping("/put")
    public SingleResponse<Refrigerator> put(@Validated @RequestBody AnimalReq animalReq) {
        return animalCenterService.put(animalReq);
    }
}
