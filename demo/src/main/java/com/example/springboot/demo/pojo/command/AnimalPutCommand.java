package com.example.springboot.demo.pojo.command;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/2/8
 * @description
 */
@Data
@AllArgsConstructor
public class AnimalPutCommand   {

    private String name;

}
