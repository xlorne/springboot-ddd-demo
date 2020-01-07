package com.example.springboot.core.view;

import lombok.Data;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Data
public class MsgReq {

    private String data;

    public static MsgReq create(String data){
        MsgReq msgReq = new MsgReq();
        msgReq.setData(data);
        return msgReq;
    }
}
