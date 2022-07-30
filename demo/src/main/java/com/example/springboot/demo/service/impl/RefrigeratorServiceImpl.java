package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.executor.RefrigeratorInitCmdExe;
import com.example.springboot.demo.pojo.command.RefrigeratorInitCommand;
import com.example.springboot.demo.service.RefrigeratorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefrigeratorServiceImpl implements RefrigeratorService {

    private RefrigeratorInitCmdExe refrigeratorInitCmdExe;

    @Override
    public void init() {
        RefrigeratorInitCommand refrigeratorInitCommand = new RefrigeratorInitCommand();
        refrigeratorInitCmdExe.execute(refrigeratorInitCommand);
    }
}
