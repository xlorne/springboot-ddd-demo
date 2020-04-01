package com.example.springboot.demo.pojo.command;

import com.alibaba.cola.dto.Executor;
import com.alibaba.cola.dto.SingleResponse;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/2/8
 * @description
 */
@Data
@AllArgsConstructor
public class AnimalReqCommand extends Executor<SingleResponse<Refrigerator>> {

    private String name;
}
