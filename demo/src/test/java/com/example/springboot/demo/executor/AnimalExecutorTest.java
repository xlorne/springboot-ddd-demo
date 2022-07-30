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

class AnimalExecutorTest {

    private RefrigeratorExecutor animalExecutor;

    private RefrigeratorRepository refrigeratorRepository;

    @BeforeEach
     void before(){
        refrigeratorRepository = Mockito.mock(RefrigeratorRepository.class);
        animalExecutor = new RefrigeratorExecutor(refrigeratorRepository);
    }

    @Test
    void executeFail() {
        try {
            RefrigeratorDTO.PutCommand putCommand = new RefrigeratorDTO.PutCommand("大象");
            Response response = animalExecutor.putAnimal(putCommand);
        }catch (Exception e){
            assertThrows(RuntimeException.class,()->{
                throw e;
            });
        }
    }

    void mock(){
        Mockito.when(refrigeratorRepository.loadSpace()).thenReturn(new Refrigerator());
    }

    @Test
    void executeSuccess(){
        mock();
        RefrigeratorDTO.PutCommand putCommand = new RefrigeratorDTO.PutCommand("大象");
        Response response =  animalExecutor.putAnimal(putCommand);
        assertTrue(response.isSuccess(),"业务执行失败");
    }
}