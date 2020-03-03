package com.example.springboot.demo.repository.db.domain;

import lombok.Data;

import java.util.Date;

/**
 * 这是一个大号的冰箱，也可以理解成为一个冰库
 */
@Data
public class Refrigerator {

    /**
     * 冰箱格栅编号
     */
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


}
