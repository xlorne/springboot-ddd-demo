package com.example.springboot.demo.domain;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Slf4j
public class RefrigeratorFactory {

   private final List<String> names = new ArrayList<>();

   private final AtomicInteger index = new AtomicInteger(0);

    public RefrigeratorFactory() {
        names.add("大象他妈妈");
        names.add("大象他弟弟");
        names.add("大象他妹妹");
        names.add("大象他哥哥");
        names.add("大象他爸爸");
        names.add("");
        names.add("");
        names.add("");
    }

    public Refrigerator randomAnimal(){
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setValue(names.get(index.getAndAdd(1)));
        refrigerator.setState(1);
        refrigerator.setTime(new Date());
        return refrigerator;
    }

    public Refrigerator randomSpace(){
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setValue(names.get(index.getAndAdd(1)));
        refrigerator.setState(0);
        refrigerator.setTime(new Date());
        return refrigerator;
    }


}
