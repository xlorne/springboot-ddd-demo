package com.example.springboot.demo.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.executor.Executor;
import com.alibaba.cola.executor.ExecutorI;
import com.example.springboot.demo.domain.model.RefrigeratorRandomProfile;
import com.example.springboot.demo.pojo.command.RefrigeratorInitCommand;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;

@Executor
@AllArgsConstructor
public class RefrigeratorInitCmdExe implements ExecutorI<Response, RefrigeratorInitCommand> {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public Response execute(RefrigeratorInitCommand cmd) {

        refrigeratorMapper.truncate();

        RefrigeratorRandomProfile refrigeratorRandomProfile = new RefrigeratorRandomProfile();

        //先把大象全家都装进冰箱...
        refrigeratorMapper.save(refrigeratorRandomProfile.randomAnimal());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomAnimal());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomAnimal());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomAnimal());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomAnimal());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomSpace());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomSpace());
        refrigeratorMapper.save(refrigeratorRandomProfile.randomSpace());

        return Response.buildSuccess();
    }
}
