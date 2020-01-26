package com.example.springboot.demo.command;

import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.Command;
import com.alibaba.cola.dto.Response;
import com.example.springboot.demo.domain.DomainFactoryHelper;
import com.example.springboot.demo.domain.DomainObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lorne
 * @date 2020/1/26
 * @description
 */
public abstract class AbsDomainCommandExecutor<R extends Response, C extends Command> implements CommandExecutorI<R,C> {

    @Autowired
    protected DomainFactoryHelper domainFactoryHelper;

    public <T extends DomainObject>T createDomain(Class<T> clazz, Object ... initargs){
        return (T)domainFactoryHelper.create(clazz,initargs);
    }


    public <T extends DomainObject>T createDomainAndExecute(Class<T> clazz, Object ... initargs){
        DomainObject domain = createDomain(clazz,initargs);
        domain.execute();
        return (T)domain;
    }

}
