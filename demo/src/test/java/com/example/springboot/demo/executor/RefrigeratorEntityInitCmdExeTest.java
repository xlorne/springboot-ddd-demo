package com.example.springboot.demo.executor;

import com.example.springboot.demo.domain.RefrigeratorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RefrigeratorEntityInitCmdExeTest {

    private RefrigeratorExecutor refrigeratorExecutor;


    @BeforeEach
    void before(){
        refrigeratorExecutor = new RefrigeratorExecutor(Mockito.mock(RefrigeratorRepository.class));
    }

    @Test
    void execute() {
        refrigeratorExecutor.init();
    }
}