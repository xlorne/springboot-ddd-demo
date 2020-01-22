package com.example.springboot.core.context;


import com.example.springboot.core.db.entity.Refrigerator;
import com.example.springboot.core.framework.context.SupportedBizContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefrigeratorData implements SupportedBizContext {

  private String data;

  private long refrigeratorId;

  private Refrigerator refrigerator;

}
