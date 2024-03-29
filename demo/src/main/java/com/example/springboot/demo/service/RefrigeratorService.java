package com.example.springboot.demo.service;

import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.example.springboot.demo.domain.Refrigerator;
import com.example.springboot.demo.executor.RefrigeratorExecutor;
import com.example.springboot.demo.pojo.command.RefrigeratorDTO;
import com.example.springboot.demo.pojo.vo.RefrigeratorVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefrigeratorService {

    private final RefrigeratorExecutor refrigeratorExecutor;

    public void init() {
        refrigeratorExecutor.init();
    }

    public SingleResponse<Refrigerator> put(RefrigeratorVO.AnimalReq animalReq) {
        RefrigeratorDTO.PutCommand putCommand = new RefrigeratorDTO.PutCommand(animalReq.getName());
        return refrigeratorExecutor.putAnimal(putCommand);
    }
}
