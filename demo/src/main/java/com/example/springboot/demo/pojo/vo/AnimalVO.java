package com.example.springboot.demo.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class AnimalVO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AnimalReq {

        private String name;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public  static class AnimalRes {

        private long id;
        private Date time;

    }

}
