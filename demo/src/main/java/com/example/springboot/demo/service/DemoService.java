package com.example.springboot.demo.service;

import com.example.springboot.demo.pojo.vo.AnimalReq;
import com.example.springboot.demo.pojo.vo.AnimalRes;

/**
 * Service层在之前的CodingAPI架构层中称为API-Service层也可以称为业务流程控制层或者应用层。 该层主要的职责是协调各Manager层完成对业务的处理，注意这里主要是做业务的编排和参数转化处理业务，不执行业务操作。
 * 举例:把大象放进冰箱中的 开门 放进大象 关门 这三步操作的顺序控制就是在该层完成。但是该层不做具体的业务逻辑，例如放大象的细节。
 */
public interface DemoService {


  AnimalRes put(AnimalReq req);


}
