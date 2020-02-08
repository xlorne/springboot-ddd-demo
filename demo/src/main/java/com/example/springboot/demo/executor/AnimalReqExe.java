package com.example.springboot.demo.executor;

import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.example.springboot.demo.domain.model.MsgDomain;
import com.example.springboot.demo.domain.model.RefrigeratorDomain;
import com.example.springboot.demo.pojo.command.AnimalReqCommand;
import com.example.springboot.demo.pojo.command.AnimalReqData;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Executor
public class AnimalReqExe implements ExecutorI<AnimalReqData, AnimalReqCommand> {

    @Override
    public AnimalReqData execute(AnimalReqCommand cmd) {

        String name = cmd.getAnimalReq().getName();

        RefrigeratorDomain refrigeratorDomain = new RefrigeratorDomain();
        refrigeratorDomain.putAnimal(name);

        long refrigeratorId = refrigeratorDomain.getRefrigerator().getId();
        MsgDomain msgDomain = new MsgDomain(refrigeratorId,name);
        msgDomain.sendMsg();

        return new AnimalReqData(refrigeratorDomain.getRefrigerator());
    }

}
