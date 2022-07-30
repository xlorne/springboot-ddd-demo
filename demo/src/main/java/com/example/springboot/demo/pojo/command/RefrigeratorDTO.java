package com.example.springboot.demo.pojo.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RefrigeratorDTO {

    @Data
    public static class MsgQuery {

        private Long refrigeratorId;

        private String animalName;
    }

    @Data
    @AllArgsConstructor
    public static class PutCommand {

        private String name;


    }

}
