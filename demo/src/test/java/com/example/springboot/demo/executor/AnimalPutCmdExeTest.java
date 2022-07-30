package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.Response;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalPutCmdExeTest {

    private AnimalPutCmdExe animalPutCmdExe;

    private RefrigeratorMapper refrigeratorMapper;

    @BeforeEach
     void before(){
        refrigeratorMapper = Mockito.mock(RefrigeratorMapper.class);
        animalPutCmdExe = new AnimalPutCmdExe(refrigeratorMapper);
    }

    @Test
    void executeFail() {
        try {
            AnimalPutCommand animalPutCommand = new AnimalPutCommand("大象");
            Response response = animalPutCmdExe.execute(animalPutCommand);
        }catch (Exception e){
            assertThrows(RuntimeException.class,()->{
                throw e;
            });
        }
    }

    void mock(){
        Mockito.when(refrigeratorMapper.findSpace()).thenReturn(new Refrigerator());
    }

    @Test
    void executeSuccess(){
        mock();
        AnimalPutCommand animalPutCommand = new AnimalPutCommand("大象");
        Response response =  animalPutCmdExe.execute(animalPutCommand);
        assertTrue(response.isSuccess(),"业务执行失败");
    }
}