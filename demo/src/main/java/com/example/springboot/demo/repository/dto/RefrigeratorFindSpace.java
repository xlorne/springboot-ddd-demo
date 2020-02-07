package com.example.springboot.demo.repository.dto;

import com.alibaba.cola.repository.CommandI;
import com.example.springboot.demo.db.domain.Refrigerator;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Data
public class RefrigeratorFindSpace implements CommandI<Refrigerator> {

    @Override
    public String command() {
        return "findSpace";
    }


}
