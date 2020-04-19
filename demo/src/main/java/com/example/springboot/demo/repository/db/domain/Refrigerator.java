package com.example.springboot.demo.repository.db.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 这是一个大号的冰箱，也可以理解成为一个冰库
 */
@Data
@Table(name = "t_refrigerator")
public class Refrigerator {

    /**
     * 冰箱格栅编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
