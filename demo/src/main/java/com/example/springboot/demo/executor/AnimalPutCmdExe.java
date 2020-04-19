package com.example.springboot.demo.executor;

import com.alibaba.cola.domain.DomainEventService;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.example.springboot.demo.domain.model.RefrigeratorProfile;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Executor
@AllArgsConstructor
public class AnimalPutCmdExe implements ExecutorI<SingleResponse<Refrigerator>, AnimalPutCommand> {

    private DomainEventService domainEventService;

    private RefrigeratorMapper refrigeratorMapper;


    @Override
    public SingleResponse<Refrigerator> execute(AnimalPutCommand cmd) {

        Refrigerator refrigerator =  refrigeratorMapper.findSpace();

        RefrigeratorProfile refrigeratorProfile = new RefrigeratorProfile(refrigerator);
        refrigeratorProfile.checkRefrigerator();
        Refrigerator newRefrigerator =   refrigeratorProfile.putAnimal(cmd.getName());

        refrigeratorMapper.update(newRefrigerator);

        long refrigeratorId = newRefrigerator.getId();

        AnimalSaveEvent animalSaveEvent = new AnimalSaveEvent();
        animalSaveEvent.setName(newRefrigerator.getValue());
        animalSaveEvent.setRefrigeratorId(refrigeratorId);
        domainEventService.publish(animalSaveEvent);

        return SingleResponse.of(newRefrigerator);
    }

}
