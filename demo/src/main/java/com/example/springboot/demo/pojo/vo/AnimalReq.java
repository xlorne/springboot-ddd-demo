package com.example.springboot.demo.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AnimalReq {

    @Size(max = 4)
    @NotEmpty
    private String name;

}
