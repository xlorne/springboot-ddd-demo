package com.example.springboot.demo.extension;

import com.alibaba.cola.extension.BizScenario;

public class BizScenarioThreadLocal {

    private BizScenarioThreadLocal(){

    }

    private static ThreadLocal<BizScenario> threadLocal = new ThreadLocal<>();

    public static BizScenario current(){
        return threadLocal.get();
    }

    public static void set(BizScenario bizScenario){
        threadLocal.set(bizScenario);
    }

    public static void clear(){
        threadLocal.set(null);
    }
}
