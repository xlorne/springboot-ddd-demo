package com.example.springboot.core.view;

import com.example.springboot.core.context.RefrigeratorContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgReq {

    private RefrigeratorContext context;

}
