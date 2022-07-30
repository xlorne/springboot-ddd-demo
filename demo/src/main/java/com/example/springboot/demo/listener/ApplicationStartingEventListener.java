package com.example.springboot.demo.listener;

import com.example.springboot.demo.service.RefrigeratorService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final  RefrigeratorService refrigeratorService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationStartingEvent) {
        refrigeratorService.init();
    }
}
