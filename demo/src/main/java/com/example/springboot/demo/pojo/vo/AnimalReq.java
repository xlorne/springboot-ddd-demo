package com.example.springboot.demo.pojo.vo;

import com.alibaba.cola.dto.Executor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AnimalReq extends Executor {

  @Size(max = 4)
  @NotEmpty
  private String name;

}
