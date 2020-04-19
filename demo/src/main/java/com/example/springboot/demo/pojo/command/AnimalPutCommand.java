package com.example.springboot.demo.pojo.command;

import com.alibaba.cola.dto.Command;
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
public class AnimalPutCommand extends Command<SingleResponse<Refrigerator>> {

    private String name;

}
