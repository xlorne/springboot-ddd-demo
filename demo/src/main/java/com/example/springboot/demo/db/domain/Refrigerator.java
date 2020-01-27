package com.example.springboot.demo.db.domain;

import com.alibaba.cola.dto.Response;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 这是一个大号的冰箱，也可以理解成为一个冰库
 */
@Data
public class Refrigerator extends Response implements Serializable {

  /**
   * 冰箱格栅编号
   */
  private int id;

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
