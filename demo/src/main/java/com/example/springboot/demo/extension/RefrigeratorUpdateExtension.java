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
@Extension(bizId = ExtensionConstants.biz, useCase = ExtensionConstants.useCase, scenario = ExtensionConstants.scenario)
@AllArgsConstructor
public class RefrigeratorUpdateExtension implements RefrigeratorUpdateExtPt {

    private RefrigeratorMapper refrigeratorMapper;

    @Override
    public void update(Refrigerator refrigerator) {
        refrigeratorMapper.updateValue(refrigerator);
    }

}
