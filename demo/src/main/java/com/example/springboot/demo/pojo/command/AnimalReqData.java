package com.example.springboot.demo.pojo.command;

import com.alibaba.cola.dto.Response;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lorne
 * @date 2020/2/8
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalReqData extends Response {

    private Refrigerator refrigerator;
}
