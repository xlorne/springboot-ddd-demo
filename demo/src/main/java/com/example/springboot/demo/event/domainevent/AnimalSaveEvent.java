package com.example.springboot.demo.event.domainevent;

import com.alibaba.cola.event.DomainEventI;
import lombok.Data;

@Data
public class AnimalSaveEvent implements DomainEventI {

    private String name;

    private Long refrigeratorId;

}
