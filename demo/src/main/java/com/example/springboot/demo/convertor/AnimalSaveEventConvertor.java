package com.example.springboot.demo.convertor;

import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.repository.db.domain.Refrigerator;

/**
 * @author lorne
 * @date 2020/2/8
 * @description
 */
public class AnimalSaveEventConvertor  {

    public static AnimalSaveEvent parser(Refrigerator refrigerator){
        AnimalSaveEvent animalSaveEvent = new AnimalSaveEvent();
        animalSaveEvent.setRefrigeratorId(refrigerator.getId());
        animalSaveEvent.setName(refrigerator.getValue());
        return animalSaveEvent;
    }

}
