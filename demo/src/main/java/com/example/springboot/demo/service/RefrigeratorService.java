package com.example.springboot.demo.service;

import com.example.springboot.demo.executor.RefrigeratorExecutor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefrigeratorService {

    private final RefrigeratorExecutor refrigeratorExecutor;

    public void init() {
        refrigeratorExecutor.init();
    }

}
