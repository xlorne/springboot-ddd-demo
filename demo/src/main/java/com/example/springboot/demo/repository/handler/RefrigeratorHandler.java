package com.example.springboot.demo.repository.handler;

import com.alibaba.cola.repository.RepositoryHandler;
import com.alibaba.cola.repository.RepositoryHandlerI;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorQuery;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/2/9
 * @description
 */
@AllArgsConstructor
@RepositoryHandler
public class RefrigeratorHandler implements RepositoryHandlerI {

    private RefrigeratorMapper refrigeratorMapper;

    private RefrigeratorQuery refrigeratorQuery;

    public void update(Refrigerator refrigerator) {
        refrigeratorMapper.updateValue(refrigerator);
    }

    public Refrigerator findSpace(){
        return refrigeratorQuery.findSpace();
    }
    

}
