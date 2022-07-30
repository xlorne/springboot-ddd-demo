package com.example.springboot.demo.domain.refrigerator;

import com.example.springboot.demo.repository.db.domain.Refrigerator;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Slf4j
public class RefrigeratorProfile {

    private final Refrigerator refrigerator;

    public RefrigeratorProfile(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    public void checkRefrigerator() {
        if (refrigerator == null) {
            throw new RuntimeException("抱歉冰箱已经满了.");
        }
    }

    /**
     * 保存动物到冰箱
     */
    public Refrigerator putAnimal(String data) {
        refrigerator.setValue(data);
        refrigerator.setTime(new Date());
        return refrigerator;
    }


}
