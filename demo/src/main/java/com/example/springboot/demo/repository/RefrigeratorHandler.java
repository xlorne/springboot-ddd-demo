package com.example.springboot.demo.repository;

import com.alibaba.cola.repository.CommandI;
import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.RepositoryHandlerI;
import com.example.springboot.demo.db.domain.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
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

    public void update(RefrigeratorUpdate refrigeratorUpdate) {
        refrigeratorMapper.updateValue(refrigeratorUpdate.getRefrigerator());
    }

    public Refrigerator findSpace(RefrigeratorFindSpace refrigeratorFindSpace){
        return refrigeratorQuery.findSpace();
    }


    @Data
    public static class RefrigeratorUpdate implements CommandI {

        private Refrigerator refrigerator;

        @Override
        public String command() {
            return "update";
        }
    }

    @Data
    public static class RefrigeratorFindSpace implements CommandI<Refrigerator> {

        @Override
        public String command() {
            return "findSpace";
        }


    }

}
