package com.example.springboot.core.framework;

import com.example.springboot.core.framework.context.BizContext;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject implements Subject {

  private List<Observer> observers = new ArrayList<>();

  @Override
  public void add(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void del(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void add(int index, Observer observer) {
    observers.add(index, observer);
  }

  @Override
  public void del(int index) {
    observers.remove(index);
  }

  @Override
  public void notifyObservers(BizContext context) {
    for(Observer observer:observers){
      observer.execute(context);
    }
  }
}
