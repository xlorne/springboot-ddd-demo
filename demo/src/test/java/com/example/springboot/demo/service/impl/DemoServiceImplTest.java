package com.example.springboot.demo.service.impl;

import com.alibaba.cola.dto.SingleResponse;
import com.example.springboot.demo.pojo.command.AnimalReqCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.feign.MessageClient;
import com.example.springboot.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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
        SingleResponse<Refrigerator> response = demoService.put(new AnimalReqCommand("大象"));
        Assert.isTrue(response.getData().getId() > 0, "保存失败.");
        log.info("res=>{}", response.getData());
    }

}