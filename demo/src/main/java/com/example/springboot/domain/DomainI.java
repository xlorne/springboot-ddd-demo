package com.example.springboot.domain;

import com.alibaba.cola.event.EventBus;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
public interface DomainI {

    void setBus(EventBus eventBus);

    void execute();

}
