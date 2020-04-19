package com.example.springboot.demo.service.impl;

import com.alibaba.cola.executor.ExecutorBus;
import com.example.springboot.demo.pojo.command.RefrigeratorInitCommand;
import com.example.springboot.demo.service.RefrigeratorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefrigeratorServiceImpl implements RefrigeratorService {

    private ExecutorBus executorBus;

    @Override
    public void init() {
        RefrigeratorInitCommand refrigeratorInitCommand = new RefrigeratorInitCommand();
        executorBus.send(refrigeratorInitCommand);
    }
}
