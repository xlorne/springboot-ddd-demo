package com.example.springboot.demo.command;

import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.event.EventBus;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;
import com.example.springboot.domain.RefrigeratorDomain;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Command
public class RefrigeratorDataExe implements CommandExecutorI<AnimalRes, AnimalReq> {

    @Autowired
    private EventBus eventBus;

    @Override
    public AnimalRes execute(AnimalReq cmd) {
        RefrigeratorDomain refrigeratorDomain = new RefrigeratorDomain(cmd.getName());
        refrigeratorDomain.setBus(eventBus);
        refrigeratorDomain.execute();
        return AnimalRes.ok(refrigeratorDomain.getId());
    }
}
