package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.codingapi.springboot.framework.event.EventPusher;
import com.example.springboot.demo.domain.Refrigerator;
import com.example.springboot.demo.domain.RefrigeratorFactory;
import com.example.springboot.demo.domain.RefrigeratorRepository;
import com.example.springboot.demo.event.RefrigeratorSaveEvent;
import com.example.springboot.demo.pojo.command.RefrigeratorDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefrigeratorExecutor {

    private final RefrigeratorRepository refrigeratorRepository;

    public void init() {

        refrigeratorRepository.truncate();

        RefrigeratorFactory factory = new RefrigeratorFactory();

        //先把大象全家都装进冰箱...
        refrigeratorRepository.save(factory.randomAnimal());
        refrigeratorRepository.save(factory.randomAnimal());
        refrigeratorRepository.save(factory.randomAnimal());
        refrigeratorRepository.save(factory.randomAnimal());
        refrigeratorRepository.save(factory.randomAnimal());
        refrigeratorRepository.save(factory.randomSpace());
        refrigeratorRepository.save(factory.randomSpace());
        refrigeratorRepository.save(factory.randomSpace());

    }


    public SingleResponse<Refrigerator> putAnimal(RefrigeratorDTO.PutCommand cmd) {
        //查询到空的地方
        Refrigerator refrigerator =  refrigeratorRepository.loadSpace();

        refrigerator.putAnimal(cmd.getName());

        //更新并落库
        refrigeratorRepository.update(refrigerator);

        //加入推送消息
        RefrigeratorSaveEvent event = new RefrigeratorSaveEvent();
        event.setName(refrigerator.getValue());
        event.setRefrigeratorId(refrigerator.getId());

        EventPusher.push(event);
        return SingleResponse.of(refrigerator);
    }

}
