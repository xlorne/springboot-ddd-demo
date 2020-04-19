package com.example.springboot.demo.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.QueryExecutorI;
import com.example.springboot.client.ao.MsgReq;
import com.example.springboot.client.ao.MsgRes;
import com.example.springboot.demo.pojo.command.AnimalMsgQuery;
import com.example.springboot.demo.repository.feign.MessageClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Executor
@AllArgsConstructor
@Slf4j
public class AnimalMsgSaveQryExe implements QueryExecutorI<Response, AnimalMsgQuery> {

    private MessageClient messageClient;

    @Override
    public Response execute(AnimalMsgQuery cmd) {
        MsgReq msgReq = new MsgReq();
        msgReq.setData(cmd.getAnimalName());
        msgReq.setRefrigeratorId(cmd.getRefrigeratorId());
        MsgRes msgRes =  messageClient.send(msgReq);
        log.info("accept:msg=>{}",msgRes);
        return Response.buildSuccess();
    }
}
