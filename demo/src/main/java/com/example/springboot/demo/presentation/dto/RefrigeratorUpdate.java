package com.example.springboot.demo.presentation.dto;

import com.alibaba.cola.presentation.PresentationI;
import com.example.springboot.demo.db.domain.Refrigerator;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Data
public class RefrigeratorUpdate implements PresentationI {

    private Refrigerator refrigerator;

}
