package com.example.springboot.core.framework.event;

import java.util.List;

public class EventBus {

  private List<Event> events;
  private List<Notify> notifies;

  public EventBus(List<Event> events,
      List<Notify> notifies) {
    this.events = events;
    this.notifies = notifies;
  }

  public <T extends Event> T getEvent(Class<T> clazz){
    if(events!=null) {
      for (Event event : events) {
        if(event.getClass().equals(clazz)){
          return (T)event;
        }
      }
    }
    throw new RuntimeException("Not find class:"+clazz.getSimpleName());
  }

  public <T extends Event> T getNotify(Class<T> clazz){
    if(notifies!=null) {
      for (Notify notify : notifies) {
        if(notify.getClass().equals(clazz)){
          return (T)notify;
        }
      }
    }
    throw new RuntimeException("Not find class:"+clazz.getSimpleName());
  }
}
