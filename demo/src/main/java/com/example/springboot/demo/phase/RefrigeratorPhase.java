package com.example.springboot.demo.phase;

import com.example.springboot.core.context.RefrigeratorData;
import com.example.springboot.core.framework.context.BizContext;
import com.example.springboot.core.framework.phase.Phase;
import com.example.springboot.core.view.MsgReq;
import com.example.springboot.core.view.MsgRes;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import com.example.springboot.demo.feign.MessageClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@AllArgsConstructor
@Slf4j
public class RefrigeratorPhase extends Phase {

  private RefrigeratorData refrigeratorData;


  /** 资源  */
  private RefrigeratorMapper refrigeratorMapper;
  private RefrigeratorQuery refrigeratorQuery;
  private MessageClient messageClient;

  public RefrigeratorPhase(
      RefrigeratorMapper refrigeratorMapper,
      RefrigeratorQuery refrigeratorQuery,
      MessageClient messageClient) {
    this.refrigeratorMapper = refrigeratorMapper;
    this.refrigeratorQuery = refrigeratorQuery;
    this.messageClient = messageClient;
  }

  /**
   * 查找冰箱的余留位置
   * @return  可存放的空间
   */
  private void findSpace() {
    refrigeratorData.setRefrigerator(refrigeratorQuery.findSpace());
  }

  private void checkRefrigerator(){
    if (refrigeratorData.getRefrigerator() == null) {
      throw new RuntimeException("抱歉冰箱已经满了.");
    }
  }

  private void setRefrigeratorItemId(){
    refrigeratorData.setRefrigeratorId(refrigeratorData.getRefrigerator().getId());
  }

  /**
   * 保存动物到冰箱
   */
  private void putAnimal() {
    refrigeratorData.getRefrigerator().setValue(refrigeratorData.getData());
    refrigeratorData.getRefrigerator().setTime(new Date());
    //放进大象 对应操作是将大象存到冰箱空间里面
    refrigeratorMapper.updateValue(refrigeratorData.getRefrigerator());
  }


  private void sendMsg(){
    MsgRes msgRes =  messageClient.send(new MsgReq(refrigeratorData.getRefrigeratorId(),refrigeratorData.getData()));
    log.info("send msg=>{}",msgRes);
  }

  @Override
  public void execute(BizContext bizContext) {

    refrigeratorData = bizContext.get(RefrigeratorData.class);

    //找一个空位置
    findSpace();
    //检查位置是否可用
    checkRefrigerator();
    //将大象放进冰箱
    putAnimal();
    //设置Id
    setRefrigeratorItemId();
    //发送消息通知
    sendMsg();

  }

}
