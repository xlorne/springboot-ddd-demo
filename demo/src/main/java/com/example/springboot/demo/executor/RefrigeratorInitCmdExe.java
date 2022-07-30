package com.example.springboot.demo.executor;

import com.codingapi.springboot.framework.dto.response.Response;
import com.example.springboot.demo.domain.refrigerator.RefrigeratorRandomProfile;
import com.example.springboot.demo.pojo.command.RefrigeratorInitCommand;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefrigeratorInitCmdExe   {

    private RefrigeratorMapper refrigeratorMapper;

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
