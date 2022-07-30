package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.Response;
import com.example.springboot.demo.pojo.command.AnimalMsgQuery;
import com.example.springboot.demo.repository.feign.MessageClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalMsgSaveQryExeTest {

    private AnimalMsgSaveQryExe animalMsgSaveQryExe;

    @BeforeEach
    void before(){
        MessageClient messageClient =  Mockito.mock(MessageClient.class);
        animalMsgSaveQryExe = new AnimalMsgSaveQryExe(messageClient);
    }

    @Test
    void execute() {
        AnimalMsgQuery animalMsgQuery = new AnimalMsgQuery();
        animalMsgQuery.setAnimalName("大象");
        animalMsgQuery.setRefrigeratorId(12L);
        Response response = animalMsgSaveQryExe.execute(animalMsgQuery);
        assertTrue(response.isSuccess(),"业务执行失败");
    }
}