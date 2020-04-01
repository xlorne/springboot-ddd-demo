package com.example.springboot.demo.executor;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.example.springboot.cola.BizScenarioThreadLocal;
import com.example.springboot.demo.domain.model.MsgTunnel;
import com.example.springboot.demo.domain.model.RefrigeratorTunnel;
import com.example.springboot.demo.extension.ExtensionConstants;
import com.example.springboot.demo.extension.RefrigeratorUpdateExtPt;
import com.example.springboot.demo.pojo.command.AnimalReqCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Executor
public class AnimalReqExe implements ExecutorI<SingleResponse<Refrigerator>, AnimalReqCommand> {


    @Override
    public SingleResponse<Refrigerator> execute(AnimalReqCommand cmd) {

        BizScenarioThreadLocal.set(ExtensionConstants.bizScenario);

        //获取参数
        String name = cmd.getName();
        //创建Domain
        RefrigeratorTunnel refrigeratorTunnel = new RefrigeratorTunnel();
        //设置扩展
        refrigeratorTunnel.putAnimal(name);

        //创建另外一个Domain
        long refrigeratorId = refrigeratorTunnel.getRefrigerator().getId();
        MsgTunnel msgTunnel = new MsgTunnel(refrigeratorId, name);
        msgTunnel.sendMsg();

        return SingleResponse.of(refrigeratorTunnel.getRefrigerator());
    }

}
