package com.example.springboot.demo.executor;

import com.alibaba.cola.aspect.ServiceEventQueue;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.example.springboot.demo.convertor.AnimalSaveEventConvertor;
import com.example.springboot.demo.domain.refrigerator.RefrigeratorProfile;
import com.example.springboot.demo.pojo.command.AnimalPutCommand;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/23
 * @description
 */
@Executor
@AllArgsConstructor
public class AnimalPutCmdExe implements ExecutorI<SingleResponse<Refrigerator>, AnimalPutCommand> {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
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
        ServiceEventQueue.push(AnimalSaveEventConvertor.parser(newRefrigerator));
        return SingleResponse.of(newRefrigerator);
    }

}
