package com.example.springboot.demo.executor;

import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.example.springboot.demo.domain.model.MsgDomain;
import com.example.springboot.demo.domain.model.RefrigeratorDomain;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Executor
public class RefrigeratorDataExe implements ExecutorI<AnimalRes, AnimalReq> {

    @Override
    public AnimalRes execute(AnimalReq cmd) {

        RefrigeratorDomain refrigeratorDomain = new RefrigeratorDomain();
        refrigeratorDomain.putAnimal(cmd.getName());

        MsgDomain msgDomain = new MsgDomain(refrigeratorDomain.getRefrigeratorId(),cmd.getName());
        msgDomain.sendMsg();

        return AnimalRes.ok(refrigeratorDomain.getRefrigeratorId());
    }

}
