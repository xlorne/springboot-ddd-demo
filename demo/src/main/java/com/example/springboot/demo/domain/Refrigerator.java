package com.example.springboot.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/23
 */
@Slf4j
@Setter
@Getter
public class Refrigerator {

    private Long id;

    /**
     * 存放的物品
     */
    private String value;


    /**
     * 更新时间
     */
    private Date time;

    /**
     * 状态 0空 1满
     */
    private int state;


    /**
     * 保存动物到冰箱
     */
    public void putAnimal(String data) {
        this.value = data;
        this.time = new Date();
    }
}
