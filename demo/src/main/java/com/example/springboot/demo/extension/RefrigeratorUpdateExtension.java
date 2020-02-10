package com.example.springboot.demo.extension;

import com.alibaba.cola.extension.Extension;
import com.example.springboot.demo.repository.db.domain.Refrigerator;
import com.example.springboot.demo.repository.db.mapper.RefrigeratorMapper;
import lombok.AllArgsConstructor;

/**
 * @author lorne
 * @date 2020/2/10
 * @description
 */
@Extension(bizId = Constants.biz,useCase = Constants.useCase,scenario = Constants.scenario)
@AllArgsConstructor
public class RefrigeratorUpdateExtension implements RefrigeratorUpdateExtPt {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public void update(Refrigerator refrigerator) {
        refrigeratorMapper.updateValue(refrigerator);
    }

}
