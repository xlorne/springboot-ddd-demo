package com.example.springboot.demo.service;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.springboot.demo.event.domainevent.AnimalSaveEvent;
import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.repository.db.domain.Refrigerator;

public interface AnimalCenterService {

    Response saveAnimal(AnimalSaveEvent animalSaveEvent);

    SingleResponse<Refrigerator> put(AnimalReq animalReq);



}
