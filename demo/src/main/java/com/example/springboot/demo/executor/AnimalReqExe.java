package com.example.springboot.demo.executor;

import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.example.springboot.demo.domain.model.MsgDomain;
import com.example.springboot.demo.domain.model.RefrigeratorDomain;
import com.example.springboot.demo.extension.ExtensionConstants;
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
        //获取参数
        String name = cmd.getName();
        //创建Domain
        RefrigeratorDomain refrigeratorDomain = new RefrigeratorDomain();
        //设置扩展
        refrigeratorDomain.setBizScenario(ExtensionConstants.bizScenario);
        refrigeratorDomain.putAnimal(name);

        //创建另外一个Domain
        long refrigeratorId = refrigeratorDomain.getRefrigerator().getId();
        MsgDomain msgDomain = new MsgDomain(refrigeratorId, name);
        msgDomain.sendMsg();

        return new AnimalReqData(refrigeratorDomain.getRefrigerator());
    }

}
