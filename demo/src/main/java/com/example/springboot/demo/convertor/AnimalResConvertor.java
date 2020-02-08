package com.example.springboot.demo.convertor;

import com.alibaba.cola.convertor.ConvertorI;
import com.example.springboot.demo.pojo.command.AnimalReqData;
import com.example.springboot.demo.pojo.vo.AnimalRes;

import java.util.Date;

/**
 * @author lorne
 * @date 2020/2/8
 * @description
 */
public class AnimalResConvertor implements ConvertorI {


    public static AnimalRes parser(AnimalReqData animalReqData) {
        AnimalRes animalRes = new AnimalRes();
        animalRes.setId(animalReqData.getRefrigerator().getId());
        animalRes.setTime(new Date());
        return animalRes;
    }
}
