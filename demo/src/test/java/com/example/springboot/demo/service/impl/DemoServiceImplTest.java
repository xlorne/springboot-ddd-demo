package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.feign.MessageClient;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;
import com.example.springboot.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.MockingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
class DemoServiceImplTest {

    @Autowired
    private DemoService demoService;

    @MockBean
    private MessageClient messageClient;


    @Test
    void put() throws Exception {
        AnimalReq animalReq = new AnimalReq();
        animalReq.setName("大象");
        AnimalRes animalRes =  demoService.put(animalReq);
        Assert.isTrue(animalRes.getId()>0,"保存失败.");
        log.info("res=>{}",animalRes);
    }

}