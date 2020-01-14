package com.example.springboot.demo.pojo.vo;

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


  public static AnimalRes ok(RefrigeratorPhase refrigeratorPhase) {
    AnimalRes res = new AnimalRes();
    res.setId(refrigeratorPhase.getRefrigeratorId());
    res.setTime(new Date());
    return res;
  }
}
