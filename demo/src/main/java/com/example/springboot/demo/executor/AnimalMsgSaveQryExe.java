package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.Response;
import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import com.example.springboot.demo.pojo.command.AnimalMsgQuery;
import com.example.springboot.demo.repository.feign.MessageClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AnimalMsgSaveQryExe   {

    private MessageClient messageClient;

    public Response execute(AnimalMsgQuery cmd) {
        MsgRes msgRes = messageClient.send(new MsgReq(cmd.getRefrigeratorId(), cmd.getAnimalName()));
        log.info("accept:msg=>{}", msgRes);
        return Response.buildSuccess();
    }
}
