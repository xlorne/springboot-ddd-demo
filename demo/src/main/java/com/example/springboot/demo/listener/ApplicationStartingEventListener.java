package com.example.springboot.demo.listener;

import com.example.springboot.demo.service.RefrigeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RefrigeratorService refrigeratorService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationStartingEvent) {
        refrigeratorService.init();
    }
}
