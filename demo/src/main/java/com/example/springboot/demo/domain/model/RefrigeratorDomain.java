package com.example.springboot.demo.domain.model;

import com.alibaba.cola.domain.DomainObject;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.handler.RefrigeratorHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Slf4j
public class RefrigeratorDomain extends DomainObject {

    @Getter
    private final Refrigerator refrigerator;

    public RefrigeratorDomain() {
        refrigerator = repository(RefrigeratorHandler.class).findSpace();
        log.info("refrigerator=>{}",refrigerator);
        checkRefrigerator();
    }


    private void checkRefrigerator(){
        if (refrigerator == null) {
            throw new RuntimeException("抱歉冰箱已经满了.");
        }
    }

    /**
     * 保存动物到冰箱
     */
    public void putAnimal(String data) {
        refrigerator.setValue(data);
        refrigerator.setTime(new Date());
        //放进大象 对应操作是将大象存到冰箱空间里面

        RefrigeratorHandler updateHandler = repository(RefrigeratorHandler.class);
        updateHandler.update(refrigerator);

    }




}
