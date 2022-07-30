package com.example.springboot.demo.event;

import com.codingapi.springboot.framework.event.IEvent;
import lombok.Data;

@Data
public class RefrigeratorSaveEvent implements IEvent {

    private String name;

    private Long refrigeratorId;

}
