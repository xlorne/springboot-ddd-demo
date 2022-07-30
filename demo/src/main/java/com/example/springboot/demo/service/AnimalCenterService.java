package com.example.springboot.demo.service;

import com.codingapi.springboot.framework.dto.response.Response;
import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.repository.db.domain.Refrigerator;

public interface AnimalCenterService {

    Response saveAnimal(AnimalSaveEvent animalSaveEvent);

    SingleResponse<Refrigerator> put(AnimalReq animalReq);



}
