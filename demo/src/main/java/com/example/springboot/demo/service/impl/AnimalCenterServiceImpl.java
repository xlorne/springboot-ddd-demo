package com.example.springboot.demo.service.impl;

import com.codingapi.springboot.framework.dto.response.Response;
import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.executor.AnimalMsgSaveQryExe;
import com.example.springboot.demo.executor.AnimalPutCmdExe;
import com.example.springboot.demo.pojo.command.AnimalMsgQuery;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.service.AnimalCenterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalCenterServiceImpl implements AnimalCenterService {

    private AnimalMsgSaveQryExe animalMsgSaveQryExe;

    private AnimalPutCmdExe animalPutCmdExe;

    @Override
    public Response saveAnimal(AnimalSaveEvent animalSaveEvent) {
        AnimalMsgQuery animalMsgQuery = new AnimalMsgQuery();
        animalMsgQuery.setAnimalName(animalSaveEvent.getName());
        animalMsgQuery.setRefrigeratorId(animalSaveEvent.getRefrigeratorId());
        return animalMsgSaveQryExe.execute(animalMsgQuery);
    }

    @Override
    public SingleResponse<Refrigerator> put(AnimalReq animalReq) {
        AnimalPutCommand animalPutCommand = new AnimalPutCommand(animalReq.getName());
        return animalPutCmdExe.execute(animalPutCommand);
    }


}
