package com.example.springboot.demo.pojo.vo;

import com.example.springboot.core.context.RefrigeratorData;
import com.example.springboot.demo.phase.RefrigeratorPhase;
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


  public static AnimalRes ok(RefrigeratorData refrigeratorData) {
    AnimalRes res = new AnimalRes();
    res.setId(refrigeratorData.getRefrigeratorId());
    res.setTime(new Date());
    return res;
  }
}
