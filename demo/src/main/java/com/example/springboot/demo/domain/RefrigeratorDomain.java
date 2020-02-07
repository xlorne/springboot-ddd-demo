package com.example.springboot.demo.domain;

import com.alibaba.cola.domain.DomainObject;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.repository.dto.RefrigeratorFindSpace;
import com.example.springboot.demo.repository.dto.RefrigeratorUpdate;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Slf4j
public class RefrigeratorDomain extends DomainObject {

    private String data;

    private Refrigerator refrigerator;
    private Long refrigeratorId;

    public RefrigeratorDomain(String data) {
        this.data = data;
    }


    @Override
    public void execute() {
        //找一个空位置
        findSpace();
        //检查位置是否可用
        checkRefrigerator();
        //将大象放进冰箱
        putAnimal();
        //发送消息通知
        sendMsg();
    }

    private void findSpace() {
        refrigerator = (Refrigerator) repositoryBus.command(new RefrigeratorFindSpace());
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

        RefrigeratorUpdate refrigeratorUpdate = new RefrigeratorUpdate();
        refrigeratorUpdate.setRefrigerator(refrigerator);
        repositoryBus.command(refrigeratorUpdate);

        refrigeratorId = refrigeratorUpdate.getRefrigerator().getId();
    }


    private void sendMsg(){
       MsgDomain msgDomain = createDomain(MsgDomain.class,refrigeratorId,data);
       msgDomain.sendMsg();
    }

    public long getId() {
        return refrigeratorId;
    }
}
