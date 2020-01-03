package com.example.springboot.messsage;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@RestController
@Slf4j
public class MsgController {

    @PostMapping("/send")
    public MsgRes send(@RequestBody MsgReq msgReq){
        log.info("msg->{}",msgReq);
        return new MsgRes(System.currentTimeMillis());
    }

}
