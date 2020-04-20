package com.example.springboot.demo.service.impl;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.executor.ExecutorBus;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.pojo.command.AnimalMsgQuery;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.service.AnimalCenterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AnimalCenterServiceImpl implements AnimalCenterService {

    private ExecutorBus executorBus;

    @Override
    public Response saveAnimal(AnimalSaveEvent animalSaveEvent) {
        AnimalMsgQuery animalMsgQuery = new AnimalMsgQuery();
        animalMsgQuery.setAnimalName(animalSaveEvent.getName());
        animalMsgQuery.setRefrigeratorId(animalSaveEvent.getRefrigeratorId());
        return executorBus.send(animalMsgQuery);
    }

    @Override
    @Transactional
    public SingleResponse<Refrigerator> put(AnimalReq animalReq) {
        AnimalPutCommand animalPutCommand = new AnimalPutCommand(animalReq.getName());
        return executorBus.send(animalPutCommand);
    }


}
