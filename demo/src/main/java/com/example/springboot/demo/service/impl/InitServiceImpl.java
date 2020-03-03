package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.service.InitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class InitServiceImpl implements InitService {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public void init() {
        refrigeratorMapper.truncate();

        //先把大象全家都装进冰箱...
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setValue("大象他妈妈");
        refrigerator.setState(1);
        refrigerator.setTime(new Date());
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("大象他弟弟");
        refrigerator.setTime(new Date());
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("大象他妹妹");
        refrigerator.setTime(new Date());
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("大象他哥哥");
        refrigerator.setTime(new Date());
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("大象他爸爸");
        refrigerator.setTime(new Date());
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("");
        refrigerator.setTime(new Date());
        refrigerator.setState(0);
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("");
        refrigerator.setTime(new Date());
        refrigerator.setState(0);
        refrigeratorMapper.save(refrigerator);

        refrigerator.setValue("");
        refrigerator.setTime(new Date());
        refrigerator.setState(0);
        refrigeratorMapper.save(refrigerator);
    }
}
