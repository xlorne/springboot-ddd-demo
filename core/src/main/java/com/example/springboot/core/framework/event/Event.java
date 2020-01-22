package com.example.springboot.core.framework.event;

public interface Event  {

  EventResponse handler(EventRequest request) throws Exception;

}
