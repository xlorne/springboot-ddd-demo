package com.example.springboot.demo.repository.dto;

import com.alibaba.cola.repository.CommandI;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Data
public class RefrigeratorFindSpace implements CommandI {

    @Override
    public String command() {
        return "findSpace";
    }


}
