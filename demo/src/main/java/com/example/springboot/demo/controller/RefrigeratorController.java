package com.example.springboot.demo.controller;

import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.example.springboot.demo.domain.Refrigerator;
import com.example.springboot.demo.pojo.vo.RefrigeratorVO;
import com.example.springboot.demo.service.RefrigeratorService;
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
public class RefrigeratorController {

    private RefrigeratorService refrigeratorService;

    @PostMapping("/put")
    public SingleResponse<Refrigerator> put(@Validated @RequestBody RefrigeratorVO.AnimalReq animalReq) {
        return refrigeratorService.put(animalReq);
    }
}
