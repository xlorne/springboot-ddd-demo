package com.example.springboot.demo.service;

import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.example.springboot.demo.domain.Refrigerator;
import com.example.springboot.demo.executor.RefrigeratorExecutor;
import com.example.springboot.demo.pojo.command.RefrigeratorDTO;
import com.example.springboot.demo.pojo.vo.AnimalVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalCenterService {

    private final RefrigeratorExecutor refrigeratorExecutor;

    public SingleResponse<Refrigerator> put(AnimalVO.AnimalReq animalReq) {
        RefrigeratorDTO.PutCommand putCommand = new RefrigeratorDTO.PutCommand(animalReq.getName());
        return refrigeratorExecutor.putAnimal(putCommand);
    }

}
