package com.example.springboot.demo.event.handler;

import com.codingapi.springboot.framework.handler.Handler;
import com.codingapi.springboot.framework.handler.IHandler;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.service.AnimalCenterService;
import lombok.AllArgsConstructor;

@Handler
@AllArgsConstructor
public class AnimalSaveEventHandler implements IHandler<AnimalSaveEvent> {

    private AnimalCenterService animalCenterService;


    @Override
    public void handler(AnimalSaveEvent animalSaveEvent) {
         animalCenterService.saveAnimal(animalSaveEvent);
    }
}
