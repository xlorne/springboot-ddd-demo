package com.example.springboot.demo.pojo.vo;

import com.example.springboot.core.context.RefrigeratorContext;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalRes {

  private long id;
  private Date time;


  public static AnimalRes ok(RefrigeratorContext refrigeratorContext) {
    AnimalRes res = new AnimalRes();
    res.setId(refrigeratorContext.getRefrigerator().getRefrigeratorId());
    res.setTime(new Date(refrigeratorContext.getTime()));
    return res;
  }
}
