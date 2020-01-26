package com.example.springboot.demo.command;

import com.alibaba.cola.command.Command;
import com.example.springboot.demo.domain.RefrigeratorDomain;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Command
public class RefrigeratorDataExe extends AbsDomainCommandExecutor<AnimalRes, AnimalReq> {

    @Override
    public AnimalRes execute(AnimalReq cmd) {
        RefrigeratorDomain refrigeratorDomain = createDomainAndExecute(RefrigeratorDomain.class,cmd.getName());
        return AnimalRes.ok(refrigeratorDomain.getId());
    }

}
