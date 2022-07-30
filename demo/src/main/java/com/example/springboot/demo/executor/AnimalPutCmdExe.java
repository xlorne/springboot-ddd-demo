package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.SingleResponse;
import com.codingapi.springboot.framework.event.EventPusher;
import com.example.springboot.demo.convertor.AnimalSaveEventConvertor;
import com.example.springboot.demo.domain.refrigerator.RefrigeratorProfile;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Component
@AllArgsConstructor
public class AnimalPutCmdExe  {

    private RefrigeratorMapper refrigeratorMapper;

    public SingleResponse<Refrigerator> execute(AnimalPutCommand cmd) {
        //查询到空的地方
        Refrigerator refrigerator =  refrigeratorMapper.findSpace();
        //通过领域完成对数据的检查
        RefrigeratorProfile refrigeratorProfile = new RefrigeratorProfile(refrigerator);
        refrigeratorProfile.checkRefrigerator();
        Refrigerator newRefrigerator =   refrigeratorProfile.putAnimal(cmd.getName());
        //更新并落库
        refrigeratorMapper.update(newRefrigerator);

        //加入推送消息
        EventPusher.push(AnimalSaveEventConvertor.parser(newRefrigerator));
        return SingleResponse.of(newRefrigerator);
    }

}
