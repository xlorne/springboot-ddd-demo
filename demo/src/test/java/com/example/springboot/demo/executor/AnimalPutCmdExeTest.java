package com.example.springboot.demo.executor;

import com.alibaba.cola.dto.Response;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalPutCmdExeTest {

    private AnimalPutCmdExe animalPutCmdExe;

    private RefrigeratorMapper refrigeratorMapper;

    @BeforeEach
    void before(){
        refrigeratorMapper = Mockito.mock(RefrigeratorMapper.class);
        Mockito.when(refrigeratorMapper.findSpace()).thenReturn(new Refrigerator());
        animalPutCmdExe = new AnimalPutCmdExe(refrigeratorMapper);
    }

    @Test
    void execute() {
        AnimalPutCommand animalPutCommand = new AnimalPutCommand("大象");
        Response response =  animalPutCmdExe.execute(animalPutCommand);
        assertTrue(response.isSuccess(),"业务执行失败");
    }
}