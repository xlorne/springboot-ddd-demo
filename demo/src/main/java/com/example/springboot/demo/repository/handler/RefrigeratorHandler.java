package com.example.springboot.demo.repository.handler;

import com.alibaba.cola.repository.CommandI;
import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.RepositoryHandlerI;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@RepositoryHandler
@AllArgsConstructor
public class RefrigeratorHandler implements RepositoryHandlerI {

    private RefrigeratorMapper refrigeratorMapper;

    private RefrigeratorQuery refrigeratorQuery;

    public void update(UpdateCmd updateCmd) {
        refrigeratorMapper.updateValue(updateCmd.getRefrigerator());
    }

    public Refrigerator findSpace(FindSpaceCmd findSpaceCmd){
        return refrigeratorQuery.findSpace();
    }


    @Data
    public static class UpdateCmd implements CommandI {

        private Refrigerator refrigerator;

        @Override
        public String command() {
            return "update";
        }
    }

    @Data
    public static class FindSpaceCmd implements CommandI<Refrigerator> {

        @Override
        public String command() {
            return "findSpace";
        }


    }

}
