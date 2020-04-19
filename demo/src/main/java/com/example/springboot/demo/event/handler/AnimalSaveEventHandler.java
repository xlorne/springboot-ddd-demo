package com.example.springboot.demo.event.handler;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.service.AnimalCenterService;
import lombok.AllArgsConstructor;

@EventHandler
@AllArgsConstructor
public class AnimalSaveEventHandler implements EventHandlerI<Response, AnimalSaveEvent> {

    private AnimalCenterService animalCenterService;

    @Override
    public Response execute(AnimalSaveEvent animalSaveEvent) {
        return animalCenterService.saveAnimal(animalSaveEvent);
    }

}
