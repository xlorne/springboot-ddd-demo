package com.example.springboot.demo.repository.dto;

import com.alibaba.cola.repository.RepositoryI;
import com.example.springboot.demo.db.domain.Refrigerator;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Data
public class RefrigeratorUpdate implements RepositoryI {

    private Refrigerator refrigerator;

}
