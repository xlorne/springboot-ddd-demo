package com.example.springboot.core.context;


import com.example.springboot.core.db.entity.Refrigerator;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefrigeratorData implements Serializable{

  private long refrigeratorId;

  private Refrigerator refrigerator;

}
