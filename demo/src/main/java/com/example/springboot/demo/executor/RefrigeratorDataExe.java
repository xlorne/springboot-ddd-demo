package com.example.springboot.demo.executor;

import com.alibaba.cola.executor.AbsDomainExecutor;
import com.alibaba.cola.executor.Executor;
import com.example.springboot.demo.domain.RefrigeratorDomain;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Executor
public class RefrigeratorDataExe extends AbsDomainExecutor<AnimalRes, AnimalReq> {

    @Override
    public AnimalRes execute(AnimalReq cmd) {
        RefrigeratorDomain refrigeratorDomain = createDomainAndExecute(RefrigeratorDomain.class,cmd.getName());
        return AnimalRes.ok(refrigeratorDomain.getId());
    }

}
