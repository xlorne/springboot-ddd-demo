package com.example.springboot.demo.pojo.command;

import com.alibaba.cola.dto.Query;
import com.alibaba.cola.dto.Response;
import lombok.Data;

@Data
public class AnimalMsgQuery extends Query<Response> {

    private Long refrigeratorId;

    private String animalName;
}
