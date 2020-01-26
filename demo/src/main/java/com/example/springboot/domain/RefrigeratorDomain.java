package com.example.springboot.domain;

import com.alibaba.cola.event.EventBus;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.event.FindRefrigeratorEventHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Slf4j
public class RefrigeratorDomain implements DomainI {

    String data;

    EventBus eventBus;

    private Refrigerator refrigerator;
    private long refrigeratorId;

    public RefrigeratorDomain(String data) {
        this.data = data;
    }

    @Override
    public void setBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void execute() {
        //找一个空位置
        findSpace();
        //检查位置是否可用
        checkRefrigerator();
        //将大象放进冰箱
        putAnimal();
        //设置Id
        setRefrigeratorItemId();
        //发送消息通知
        sendMsg();
    }

    private void findSpace() {
        FindRefrigeratorEventHandler.FindRefrigeratorEvent event = new FindRefrigeratorEventHandler.FindRefrigeratorEvent();
        refrigerator = (Refrigerator)eventBus.fire(event);
        log.info("refrigerator=>{}",refrigerator);
    }

    private void checkRefrigerator(){
        if (refrigerator == null) {
            throw new RuntimeException("抱歉冰箱已经满了.");
        }
    }

    /**
     * 保存动物到冰箱
     */
    private void putAnimal() {
        refrigerator.setValue(data);
        refrigerator.setTime(new Date());
        //放进大象 对应操作是将大象存到冰箱空间里面
        eventBus.fire(refrigerator);
    }

    private void setRefrigeratorItemId(){
        refrigeratorId = refrigerator.getId();
    }

    private void sendMsg(){
        MsgReq msgReq = new MsgReq(refrigeratorId,data);
        MsgRes msgRes = (MsgRes) eventBus.fire(msgReq);
        log.info("send msg=>{}",msgRes);
    }

    public long getId() {
        return refrigeratorId;
    }
}
