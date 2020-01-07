package com.example.springboot.demo.manager;

import com.example.springboot.demo.manager.domain.Refrigerator;
import com.example.springboot.demo.manager.mapper.RefrigeratorMapper;
import com.example.springboot.demo.manager.mapper.RefrigeratorQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Manager层，在之前的CodingAPI架构中对应的是模块层，这里也可以理解是DDD中的领域层。该层负责具体的业务控制细节，但是其控制的资源是有限的受限于其db层的资源。
 * 注意该层中的资源操作仅限于自己的模块资源内的，禁止对其他资源的操作。在定义Manager层的其具体的资源是固定的，研发人员不允许添加新的资源进来，而且Manager层与层之前的最小资源严格来说也不允许出现重复。
 */
@Repository
@AllArgsConstructor
public class RefrigeratorManager {

    private RefrigeratorMapper refrigeratorMapper;

    private RefrigeratorQuery refrigeratorQuery;


    public Refrigerator findSpace() {
        Refrigerator refrigerator =  refrigeratorQuery.findSpace();
        if(refrigerator==null){
            throw new RuntimeException("抱歉冰箱已经满了.");
        }
        return refrigerator;
    }


    public void putAnimal(int id, String name) {
        refrigeratorMapper.updateValue(name,new Date(),id);
    }

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
