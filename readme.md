# 如何做好一个后端项目
[![Build Status](https://travis-ci.org/1991wangliang/springboot-demo.svg?branch=new)](https://travis-ci.org/1991wangliang/springboot-demo)
[![codecov](https://codecov.io/gh/1991wangliang/springboot-demo/branch/master/graph/badge.svg)](https://codecov.io/gh/1991wangliang/springboot-demo)

什么样的项目是一个好的项目,如何做好一个项目？这个问题我考虑过很久，由于之前一直做项目外包，也接触到的了比较多的项目，但是我一直没有感觉到自己做过的哪个项目是可以称为好项目，我提交的这份代码，或许也是很多研发人员开发业务的风格。

## 系统介绍

四层架构设计介绍:    
Controller 层负责完成对数据的非业务性校验，Controller层直接调用Service层。    
Service 层负责完成业务的流水线编排控制，主要完成业务的流转控制和流转直接的数据处理。对应类型的转化建议放到Entity内部完成，简化业务代码的整洁易读性。    
Manager 层是指具体业务模块的业务逻辑控制，也可以理解为是模块或者领域的概念，每一个Manger明确其管理的资源数据，在微服务架构中RPC层对应的也是Manager层。    
DB 层分为Query和Update操作，直接对数据做处理。    

本代码以把大象放进冰箱功能为例，详细展示了各个模块的业务控制。
![](img/4.png)

## 关于敏捷开发
敏捷开发的关键是：阶段性发布可用功能版本，长期持续的推进项目进度。其实还是比较好理解的，但是如何才能做好呢？实际上很多项目的研发过程就像是在垒扑克牌，一对一对的垒，越垒越高，在垒到足够高的时候，去调整一个小功能时却导致了整盘的倒塌。但是再回过头来看垒扑克牌的过程时，你却会觉得自己是采用了敏捷开发啊，也确实是一个迭代一个迭代的垒的啊。
```
       /\
      /\/\                /\
     /\/\/\      /\      /\/\
    /\/\/\/\    /\/\    /\/\/\
   /\/\/\/\/\  /\/\/\  /\/\/\/\
  /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
 /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
```


## 一个好的后端项目指标

* 有良好的代码规范
    1. 良好的代码风格
    2. 良好的注释规范
* 有完善的资料与文档
    1. 业务流程文档
    2. 架构设计文档
    3. 实现流程文档
* 项目功能与业务相匹配
    1. 测试用例与功能相符
    2. 单元测试与业务相符
    3. 可通过单元测试与功能测试
* 达到系统性能要求
    1. 评估满足用户的性能要求
    2. 压测可满足预估的性能要求
    3. 系统性能可通过负载提升
* 采用成熟完善的技术与框架
    1. 成熟完善及使用者多文档全面
    2. 有良好的服务,出现问题可解决
* 拥有达标覆盖率的单元测试
    1. 确保业务代码可正常执行
    2. 不依赖其他模块或数据可独立运行
    3. 执行完成以后不产生脏数据
    4. 完成单元测试要对业务产生的影响做检查
    5. 单元测试可尽量覆盖所有的业务
* 他人可轻易的扩展维护
    1. 有良好的代码风格与注释
    2. 有相对完善的资料文档
    3. 有相对全面的单元测试
    4. 有良好的设计模式，可支持添加功能时尽量增加而不修改
 
## 开发规范要求

### 代码规范
[Google Java Code Style](https://blog.csdn.net/yuanmomoya/article/details/100100514)

###  注释要求

项目中着重需要在Service层以及Manager层写清楚业务执行的逻辑注释。对业务流程比较复杂的可以通过列步骤来说,1、2、3..

DemoService层代码示例如下:
```java
  /**
   * 将大象放进冰箱
   * 1、找到冰箱的有效空间
   * 2、将大象存进冰箱
   * 3、通知消息已存放成功
   * 
   * @param req 大象
   * @return  大象所在位置
   */
  @Override
  @Transactional
  public AnimalRes put(AnimalReq req) {
    String name = req.getName();

    //放进大象 对应操作是将大象存到冰箱空间里面
    int id =refrigeratorManager.putAnimal(name);

    //关闭冰箱 对应操作是提交事务，实际本地事务已提交,这里就换成发送一条通知消息
    messageClient.send(MsgReq.create(id,name));

    return AnimalRes.ok(id);
  }
  
```

Manager层代码示例如下:
```java
  /**
   * 查找冰箱的余留位置
   * @return  可存放的空间
   */
  public Refrigerator findSpace() {
    Refrigerator refrigerator = refrigeratorQuery.findSpace();
    if (refrigerator == null) {
      throw new RuntimeException("抱歉冰箱已经满了.");
    }
    return refrigerator;
  }


  /**
   * 保存动物到冰箱
   * 1、先从冰箱中找到一个位置
   * 2、然后将动物保存到冰箱中
   * @param name  动物名称
   * @return  格栅Id
   */
  public int putAnimal(String name) {
    //打开冰箱 对应操作是找到一个存储大象的空间
    Refrigerator refrigerator =  findSpace();
    //放进大象 对应操作是将大象存到冰箱空间里面
    refrigeratorMapper.updateValue(name, new Date(), refrigerator.getId());

    //返回格栅Id
    return refrigerator.getId();
  }
```

### 层次划分要求

 



