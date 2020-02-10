package com.example.springboot.demo.pojo.command;

import com.alibaba.cola.dto.Executor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/2/8
 * @description
 */
@Data
@AllArgsConstructor
public class AnimalReqCommand extends Executor<AnimalReqData> {

    private String name;
}
