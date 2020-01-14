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

    public static MsgReq create(long id,String name){
        MsgReq msgReq = new MsgReq();
        String data = String.format("%s->id:%d", name,id);
        msgReq.setData(data);
        return msgReq;
    }
}
