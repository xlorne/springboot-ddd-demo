package com.example.springboot.demo.domain.model;

import com.example.springboot.demo.repository.db.domain.Refrigerator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Slf4j
public class RefrigeratorRandomProfile {

   private List<String> names = new ArrayList<>();

   private int index = 0;

    public RefrigeratorRandomProfile() {
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
        refrigerator.setValue(names.get(index++));
        refrigerator.setState(1);
        refrigerator.setTime(new Date());
        return refrigerator;
    }

    public Refrigerator randomSpace(){
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setValue(names.get(index++));
        refrigerator.setState(0);
        refrigerator.setTime(new Date());
        return refrigerator;
    }


}
