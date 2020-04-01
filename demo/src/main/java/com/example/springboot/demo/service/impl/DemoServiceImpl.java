package com.example.springboot.demo.service.impl;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.executor.ExecutorBus;
import com.example.springboot.demo.pojo.command.AnimalReqCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author lorne
 */
@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {


    private ExecutorBus executorBus;



    @Override
    public SingleResponse<Refrigerator> put(AnimalReqCommand animalReqCommand) throws Exception {
        return executorBus.send(animalReqCommand);
    }
}
