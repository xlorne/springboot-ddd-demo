package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.Response;
import com.example.springboot.demo.domain.Refrigerator;
import com.example.springboot.demo.domain.RefrigeratorRepository;
import com.example.springboot.demo.pojo.command.RefrigeratorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RefrigeratorExecutorTest {

    private RefrigeratorExecutor refrigeratorExecutor;

    private RefrigeratorRepository refrigeratorRepository;

    @BeforeEach
     void before(){
        refrigeratorRepository = Mockito.mock(RefrigeratorRepository.class);
        refrigeratorExecutor = new RefrigeratorExecutor(refrigeratorRepository);
    }

    @Test
    void putFail() {
        try {
            RefrigeratorDTO.PutCommand putCommand = new RefrigeratorDTO.PutCommand("大象");
            Response response = refrigeratorExecutor.putAnimal(putCommand);
        }catch (Exception e){
            assertThrows(RuntimeException.class,()->{
                throw e;
            });
        }
    }


    @Test
    void putSuccess(){
        Mockito.when(refrigeratorRepository.loadSpace()).thenReturn(new Refrigerator());
        RefrigeratorDTO.PutCommand putCommand = new RefrigeratorDTO.PutCommand("大象");
        Response response =  refrigeratorExecutor.putAnimal(putCommand);
        assertTrue(response.isSuccess(),"业务执行失败");
    }

    @Test
    void init() {
        refrigeratorExecutor.init();
    }
}