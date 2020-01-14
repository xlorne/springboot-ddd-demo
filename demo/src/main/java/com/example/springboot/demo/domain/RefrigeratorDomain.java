package com.example.springboot.demo.domain;

import com.example.springboot.core.view.MsgReq;
import com.example.springboot.demo.db.entity.Refrigerator;
import com.example.springboot.demo.db.mapper.RefrigeratorMapper;
import com.example.springboot.demo.db.mapper.RefrigeratorQuery;
import com.example.springboot.demo.feign.MessageClient;
import java.util.Date;
import lombok.AllArgsConstructor;

/**
 * Manager层，在之前的CodingAPI架构中对应的是模块层，这里也可以理解是DDD中的领域层。该层负责具体的业务控制细节，但是其控制的资源是有限的受限于其db层的资源。
 * 注意该层中的资源操作仅限于自己的模块资源内的，禁止对其他资源的操作。在定义Manager层的其具体的资源是固定的，研发人员不允许添加新的资源进来，而且Manager层与层之前的最小资源严格来说也不允许出现重复。
 */

@AllArgsConstructor
public class RefrigeratorDomain {

  private long refrigeratorId;

  private Refrigerator refrigerator;

  private String data;


  private RefrigeratorMapper refrigeratorMapper;

  private RefrigeratorQuery refrigeratorQuery;

  private MessageClient messageClient;


  public RefrigeratorDomain(
      RefrigeratorMapper refrigeratorMapper,
      RefrigeratorQuery refrigeratorQuery,
      MessageClient messageClient) {
    this.refrigeratorMapper = refrigeratorMapper;
    this.refrigeratorQuery = refrigeratorQuery;
    this.messageClient = messageClient;
  }


  public void initData(String data){
    this.data =data;
  }

  /**
   * 查找冰箱的余留位置
   * @return  可存放的空间
   */
  public void findSpace() {
    refrigerator = refrigeratorQuery.findSpace();
  }


  public void checkRefrigerator(){
    if (refrigerator == null) {
      throw new RuntimeException("抱歉冰箱已经满了.");
    }
  }

  /**
   * 保存动物到冰箱
   */
  public void putAnimal() {
    //放进大象 对应操作是将大象存到冰箱空间里面
    refrigeratorMapper.updateValue(data, new Date(), refrigerator.getId());
    //返回格栅Id
    refrigeratorId = refrigerator.getId();
  }

  public void sendMsg(){
    messageClient.send(MsgReq.create(refrigeratorId,data));
  }

  public long getRefrigeratorId() {
    return refrigeratorId;
  }
}
