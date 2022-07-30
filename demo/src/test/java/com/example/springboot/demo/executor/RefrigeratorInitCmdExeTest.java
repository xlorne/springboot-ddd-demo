package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.Response;
import com.example.springboot.demo.pojo.command.RefrigeratorInitCommand;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RefrigeratorInitCmdExeTest {

    private RefrigeratorInitCmdExe refrigeratorInitCmdExe;


    @BeforeEach
    void before(){
        refrigeratorInitCmdExe = new RefrigeratorInitCmdExe(Mockito.mock(RefrigeratorMapper.class));
    }

    @Test
    void execute() {
        Response response =  refrigeratorInitCmdExe.execute(new RefrigeratorInitCommand());
        assertTrue(response.isSuccess(),"业务执行失败");
    }
}