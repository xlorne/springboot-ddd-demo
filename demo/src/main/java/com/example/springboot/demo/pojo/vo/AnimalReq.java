package com.example.springboot.demo.pojo.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class AnimalReq {

    @Length(max = 4)
    @NotEmpty
    private String name;

}
