package com.example.springboot.demo.domain;


import com.alibaba.cola.event.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lorne
 * @date 2020/1/26
 * @description
 */
@AllArgsConstructor
@Component
public class DomainFactoryHelper<T extends DomainObject> implements DomainFactoryI<T> {

    private EventBus eventBus;

    @Override
    public T create(Class<T> clazz,Object ... initargs) {
        List<Class<?>> list =null;
        if(initargs!=null){
            list = new ArrayList<>();
            for (Object obj:initargs){
                list.add(obj.getClass());
            }
        }
        Class<?>[] parameterTypes = list!=null?list.toArray(new Class[]{}):null;
        try {
            DomainObject domain = clazz.getDeclaredConstructor(parameterTypes).newInstance(initargs);
            domain.initEventBus(eventBus);
            return (T)domain;
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
