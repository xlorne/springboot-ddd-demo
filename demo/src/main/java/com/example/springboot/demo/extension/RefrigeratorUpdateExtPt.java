package com.example.springboot.demo.extension;

import com.alibaba.cola.extension.ExtensionPointI;
import com.example.springboot.demo.repository.db.domain.Refrigerator;

/**
 * @author lorne
 * @date 2020/2/10
 * @description
 */
public interface RefrigeratorUpdateExtPt extends ExtensionPointI {

    void update(Refrigerator refrigerator);

}
