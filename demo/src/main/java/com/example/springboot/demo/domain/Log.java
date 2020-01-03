package com.example.springboot.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Data
public class Log {

    private int id;

    private String name;

    private Date time;

}
