package com.example.springboot.demo.extension;

import com.alibaba.cola.extension.BizScenario;

/**
 * @author lorne
 * @date 2020/2/10
 * @description
 */
public class ExtensionConstants {

    public static final String biz = "demo";

    public static final String useCase = "refrigerator";

    public static final String scenario = "update";

    public static final BizScenario bizScenario =
            BizScenario.valueOf(
                    ExtensionConstants.biz,
                    ExtensionConstants.useCase,
                    ExtensionConstants.scenario);
}
