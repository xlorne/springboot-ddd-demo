package com.example.springboot.core.framework;

public interface Subject {

  /*增加观察者*/
  void add(Observer observer);

  /*增加观察者*/
  void add(int index, Observer observer);

  /*删除观察者*/
  void del(Observer observer);

  void del(int index);

  /*通知所有的观察者*/
  void notifyObservers(BizContext bizContext);

  /*自身的操作*/
  void operation(BizContext bizContext);


}
