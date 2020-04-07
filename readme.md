# 如何做好一个后端项目
[![Build Status](https://travis-ci.org/1991wangliang/springboot-demo.svg?branch=new)](https://travis-ci.org/1991wangliang/springboot-demo)
[![codecov](https://codecov.io/gh/1991wangliang/springboot-demo/branch/master/graph/badge.svg)](https://codecov.io/gh/1991wangliang/springboot-demo)

什么样的项目是一个好的项目,如何做好一个项目？这个问题我考虑过很久，由于之前一直做项目外包，也接触到的了比较多的项目，但是我一直没有感觉到自己做过的哪个项目是可以称为好项目，当然做好项目不仅仅单是技术层面的，需要考虑到把握好功能与客户关系、需要有良好的团队配合、考核体系、晋升体系、检查体系等等一系列的保障机制，我们先只从技术层面出发来考虑如何做好一个后端项目。

慢慢看清楚领域模型之后，才有了些体会。先说一下我的结论:颗粒度越大(函数方法代码量越多)，功能调整的可能性就会越大，出现BUG的可能性也会越大，要时刻想尽一切办法去减小颗粒度，这也将会驱使你不断进步。
 
## 系统介绍

本项目依赖COLA，运行本项目前需要先将COLA安装到本地。源码维护见: https://github.com/1991wangliang/COLA    

![COLA架构图](img/cola.png)

层次介绍:      

|  层次    | 说明  |
|  :----  | :----  |
| controller  |  提供服务的访问层，目前采用RestController的方式，也做基础数据格式校验的业务。  |
| service  |  对应上图中的services部分，将被controller使用，定义的传入传出是executor定义的command与Data格式。 |
| convertor  | 适配层，适配层的存在也是为了避免各层次间的强依赖,为了更清新的划分清楚层次，如command对象将不直接依赖vo对象，而是通过convertor或构造数据做适配 |
| executor  | 具体业务命令的逻辑编排与执行，这是业务逻辑处理的关键地方。|
| extension  | 业务扩展层，可扩展多种业务实现，COLA提供了全局的策略规范。 |
| domain  | 洋葱图的核心部分:领域层，domain领域分为model与service(action),model领域的final是数据，service是动作 |
| pojo  | 数据dto对象，分为command/vo/co/ao... 等不同的dto对象  |
| repository  | 资源层相对来说比较广泛，最基本的是对db的操作，对其他模块的操作(feign)，对搜索引擎或消息队列的操作都属于资源。可细分为:feign、db、search、message  | 
            
本项目功能:把大象放进冰箱，本项目的代码是我刚开始上路的起步阶段，还有很多不足，大家仅做参考。     

### 我的落地方式  
我对领域的理解从刚开始的探索，到慢慢在实际项目中使用有经历了一段时间。但一直感觉很难完全模仿张建飞老师在demo中的写法方式，或许是因为我个人技艺不精吧，总感觉写出来的业务代码反而更加复杂化了。
我在结合COLA的理解，以及我们项目的推进方式上总结了一套，我们可推行的方式，下面我分享给大家，还望多多指教。

* 业务需求分析    
根据业务功能需求，分析系统中的用例，并画出各个用例的业务关键流程图，流程图中只关心影响业务走向的动作。
* 业务领域建模   
划分领域模块，参考[四色建模](https://blog.csdn.net/phenixIII/article/details/16341389?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task)的方式，根据上面画出的流程图，标记出来业务关键数据作为领域的名称。这些领域将都是业务流转过程中留下的业务关键足迹数据。   
* 数据库建模    
数据库建模或者说是数据库建表，建表需要考虑业务逻辑和界面数据展示，然后设计出来表结构，根据表对应领域的划分，将对应的Tunnel放在对应的领域中。   
* 分析复用业务    
当数据库结构与领域模块建立以后，根据业务流程图可以比较容易的分析出那些功能流程在系统中会被多个地方调用。将这些会被复用的业务流程做成可复用的Event。  

关于Executor(Application Service)的认识     
executor是作为业务的核心处理类，是业务的具体实现过程。根据项目的数据特点分为两种Executor，一种查询业务，一种是操作业务。      
查询业务:往往是直接对数据库表做查询的业务，通常返回详情、列表、分页格式的数据，这一类的接口通常不会有复杂的逻辑业务只需要查询然后直接返回数据。     
操作业务:该类型的业务往往是伴随着逻辑的，比如创建订单时需要检查商品、用户等信息，比如发货时需要检查收获人的信息等。对于这一类的业务有会区分为三种操作方式，分别是业务逻辑、数据逻辑、资源操作。     
业务逻辑:是指不依赖数据的业务检查、判断、校验、数据组装等行为的逻辑代码，例如下单时需要计算平台抽佣金额，那可以将抽佣金额计算的逻辑放在业务逻辑中实现。       
数据逻辑:是指依赖表数据为检查、判断的代码，比如检查订单状态是否正常，保存、修改订单数据等操作。     
资源操作:是指需要对批量数据做检查、或对批量数据做修改保存的代码逻辑，他区别与数据逻辑的地方是，他是同事对多条记录做检查与操作的。    

项目中复用的地方:    
1、executor层的复用，这些复用点都是业务流程中某些被大量互相依赖调用的功能流程。     
2、业务逻辑复用，并不一定所有定义的业务逻辑都会被复用到，但是某些业务逻辑是需要复用的，利用分佣计算。   
3、数据逻辑复用，将会在项目中大量存在，这些复用点都是些对单数据做的些简单逻辑检查或是数据操作。    


如下代码分别是下单与确认售后的部分代码实现逻辑:
```java
    
    @Override
    public SingleResponse<OrderAddData> execute(OrderAddCommand cmd) {
        //用户地址检查
        AddressTunnel addressTunnel = new AddressTunnel(cmd.getAddressKid());
        String addressInfo = addressTunnel.addressInfo();
        //商家数据检查
        BusinessTunnel businessTunnel = new BusinessTunnel(cmd.getBuyBusinessKid());
        //获取佣金数据
        ProfitTunnel profitTunnel = new ProfitTunnel(businessTunnel.getCityPartnerKid(), businessTunnel.getRegionPartnerKid());
        //佣金计算
        OrderCalculateInf calculateProfit = profitTunnel.calculateProfit(cmd.getSellingPrice(), cmd.getReferPrice());
        //转换Order对象
        OrderTunnel orderTunnel = new OrderTunnel(OrderConvertor.createOrder(calculateProfit, cmd, addressInfo, addressTunnel.getKid()));
        //保存订单
        orderTunnel.save();
        //保存商品
        List<PartsInfo> partsInfoList = PartsInfoConvertor.parser(orderTunnel.getOrderId(), cmd.getPartsInfs());
        orderRepository.savePartsInfo(partsInfoList);
        //返回数据
        OrderAddData orderAddData = new OrderAddData(orderTunnel.getOrderId(), orderTunnel.getCreateTime(), orderTunnel.getOrderKid());
        return SingleResponse.of(orderAddData);
    }


    @Override
    public Response execute(SubmitAfterSaleCommand cmd) {
        AfterSaleTunnel afterSaleTunnel = new AfterSaleTunnel(cmd.getAfterSaleId());
        afterSaleTunnel.checkRunSate();

        OrderTunnel orderTunnel = new OrderTunnel(afterSaleTunnel.getOrderId());
        //订单若还尚未完成时需要在售后完成后结束订单
        boolean orderRunning = !orderTunnel.isFinishState();

        // 添加对账记录
        ReconciliationAddEvent reconciliationAddEvent = new ReconciliationAddEvent();
        reconciliationAddEvent.setAfterSaleId(afterSaleTunnel.getAfterSaleId());
        domainEventPublisher.publish(reconciliationAddEvent);

        if(orderTunnel.isCredit()){
            //添加挂账售后记录
            CreditRecordingAddEvent creditRecordingAddEvent = new CreditRecordingAddEvent();
            creditRecordingAddEvent.setAfterSaleId(afterSaleTunnel.getAfterSaleId());
            domainEventPublisher.publish(creditRecordingAddEvent);
        }

        if(orderTunnel.isOnlinePay()){
            //退款
            PayType payType = orderTunnel.getPayType();
            PayRefund payRefund = PaySelecter.select(payType,orderTunnel.getInvoiceType(), PayRefund.class);
            boolean isOver = payRefund.refund(orderTunnel.getTransactionId(),new PayMoney(afterSaleTunnel.getSellMoney()),new PayMoney(afterSaleTunnel.getSellMoney()));
            if(!isOver){
                domainEventPublisher.publish(AfterSaleRecordingAddEvent.builder().afterSaleId(afterSaleTunnel.getAfterSaleId()).build());
            }
        }else {
            domainEventPublisher.publish(AfterSaleRecordingAddEvent.builder().afterSaleId(afterSaleTunnel.getAfterSaleId()).build());
        }

        afterSaleTunnel.overSate();

        //添加负分佣记录
        IncomeAddEvent incomeAddEvent = new IncomeAddEvent();
        incomeAddEvent.setAfterSaleId(afterSaleTunnel.getAfterSaleId());
        domainEventPublisher.publish(incomeAddEvent);

        if(orderRunning){
            domainEventPublisher.publish(new ConfirmReceiptEvent(orderTunnel.getOrderKid()));
        }
        return Response.buildSuccess();
    }
```
给大家的建议:   

* 层次的分明是件非常重要的事情，他将会帮助你细分颗粒度，就好比是垃圾分类一样，它会让你清楚每段代码该扔到那个桶中，是达到让上帝的归上帝凯撒的归凯撒效果的根本。    
* 要学会用类去实现业务，而不是以面向过程式的函数去实现功能，以类实现功能你将会更容易的去细分颗粒度，可让复杂的业务简单化。      
* 当你慢慢习惯了用类去解决问题的时候，还需要留意我下文中提到那些设计模式原则，他将会让你更加清晰的去定义一个类的功能职责。    


关于Convert使用说明:     
* 由于很多地方需要数据类型的转换，经常会出现 XXX.parser(). 容易被滥用需要区分 Factory和Convert的差异。Factory会做一些默认字段的赋值，Convert只是做转换。 


## 关于敏捷开发
敏捷开发的关键是：阶段性发布可用功能版本，长期持续的推进项目进度。其实是比较好理解的，但是如何才能确保做好呢？实际上很多项目的研发过程就像是在垒扑克牌，一对一对的垒，越垒越高，在垒到足够高的时候，去调整一个小功能时却导致了整盘的倒塌，敏捷并不是做好项目的方法，在我看来敏捷只是一中项目。
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
 
 

 
## 怎么做才能做好项目

要时刻提醒自己: 要看清目标,掌握好方向。

* 努力的方向
  1. 颗粒度越大(函数代码量越大)，功能调整的可能性就会越大，出现BUG的可能性也会越大，时刻要想尽一切办法去减小颗粒度，这也将会驱使你不断进步。           
* 努力的目标  
  1. 既开闭原则,最终实现在扩展功能时，做到只增加而不修改。   

有了目标和方向了，你还不知从何下手？        
首先要先摆脱函数式编程，开始拥抱面向对象，要准守规范与原则，拒绝CV战士。为什么这样呢？若不懂的话请先看下面的两个链接文章，若还不懂，却依旧渴望真理的话，那请提交issue留言，我可以专门做个视频讲讲为什么。   


## 领域模型、贫血模型、充血模型概念总结
领域模型是对领域内的概念类或现实世界中对象的可视化表示。又称概念模型、领域对象模型、分析对象模型。它专注于分析问题领域本身，发掘重要的业务领域概念，并建立业务领域概念之间的关系。    
业务对象模型（也叫领域模型domain model）是描述业务用例实现的对象模型。它是对业务角色和业务实体之间应该如何联系和协作以执行业务的一种抽象。业务对象模型从业务角色内部的观点定义了业务用例。该模型为产生预期效果确定了业务人员以及他们处理和使用的对象（“业务类和对象”）之间应该具有的静态和动态关系。它注重业务中承担的角色及其当前职责。这些模型类的对象组合在一起可以执行所有的业务用例。    
[领域模型、贫血模型、充血模型概念总结](https://blog.csdn.net/u010955843/article/details/45337771)   
[复杂业务代码要怎么写](https://blog.csdn.net/significantfrank/article/details/98087611)  
[分离业务逻辑和技术细节](https://blog.csdn.net/significantfrank/article/details/94593620)    

## 遵守的原则

[软件设计模式概述](http://c.biancheng.net/view/1317.html)

### 开闭原则的定义
开闭原则（Open Closed Principle，OCP）由勃兰特·梅耶（Bertrand Meyer）提出，他在 1988 年的著作《面向对象软件构造》（Object Oriented Software Construction）中提出：软件实体应当对扩展开放，对修改关闭（Software entities should be open for extension，but closed for modification），这就是开闭原则的经典定义。    

这里的软件实体包括以下几个部分：   
项目中划分出的模块   
类与接口   
方法    

开闭原则的含义是：当应用的需求改变时，在不修改软件实体的源代码或者二进制代码的前提下，可以扩展模块的功能，使其满足新的需求。   
开闭原则的作用    
开闭原则是面向对象程序设计的终极目标，它使软件实体拥有一定的适应性和灵活性的同时具备稳定性和延续性。具体来说，其作用如下。    
1. 对软件测试的影响
软件遵守开闭原则的话，软件测试时只需要对扩展的代码进行测试就可以了，因为原有的测试代码仍然能够正常运行。
2. 可以提高代码的可复用性
粒度越小，被复用的可能性就越大；在面向对象的程序设计中，根据原子和抽象编程可以提高代码的可复用性。
3. 可以提高软件的可维护性
遵守开闭原则的软件，其稳定性高和延续性强，从而易于扩展和维护。

### 里氏替换原则

里氏替换原则（Liskov Substitution Principle，LSP）由麻省理工学院计算机科学实验室的里斯科夫（Liskov）女士在 1987 年的“面向对象技术的高峰会议”（OOPSLA）上发表的一篇文章《数据抽象和层次》（Data Abstraction and Hierarchy）里提出来的，她提出：继承必须确保超类所拥有的性质在子类中仍然成立（Inheritance should ensure that any property proved about supertype objects also holds for subtype objects）。     

里氏替换原则主要阐述了有关继承的一些原则，也就是什么时候应该使用继承，什么时候不应该使用继承，以及其中蕴含的原理。里氏替换原是继承复用的基础，它反映了基类与子类之间的关系，是对开闭原则的补充，是对实现抽象化的具体步骤的规范。    
里氏替换原则的作用    
里氏替换原则的主要作用如下。    
1. 里氏替换原则是实现开闭原则的重要方式之一。
2. 它克服了继承中重写父类造成的可复用性变差的缺点。
3. 它是动作正确性的保证。即类的扩展不会给已有的系统引入新的错误，降低了代码出错的可能性。

### 依赖倒置原则

依赖倒置原则（Dependence Inversion Principle，DIP）是 Object Mentor 公司总裁罗伯特·马丁（Robert C.Martin）于 1996 年在 C++ Report 上发表的文章。    

依赖倒置原则的原始定义为：高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象（High level modules shouldnot depend upon low level modules.Both should depend upon abstractions.Abstractions should not depend upon details. Details should depend upon abstractions）。其核心思想是：要面向接口编程，不要面向实现编程。   

依赖倒置原则是实现开闭原则的重要途径之一，它降低了客户与实现模块之间的耦合。    

由于在软件设计中，细节具有多变性，而抽象层则相对稳定，因此以抽象为基础搭建起来的架构要比以细节为基础搭建起来的架构要稳定得多。这里的抽象指的是接口或者抽象类，而细节是指具体的实现类。    

使用接口或者抽象类的目的是制定好规范和契约，而不去涉及任何具体的操作，把展现细节的任务交给它们的实现类去完成。     
依赖、倒置原则的作用    
依赖倒置原则的主要作用如下。   
1. 依赖倒置原则可以降低类间的耦合性。
2. 依赖倒置原则可以提高系统的稳定性。
3. 依赖倒置原则可以减少并行开发引起的风险。
4. 依赖倒置原则可以提高代码的可读性和可维护性。

### 单一职责原则
单一职责原则（Single Responsibility Principle，SRP）又称单一功能原则，由罗伯特·C.马丁（Robert C. Martin）于《敏捷软件开发：原则、模式和实践》一书中提出的。这里的职责是指类变化的原因，单一职责原则规定一个类应该有且仅有一个引起它变化的原因，否则类应该被拆分（There should never be more than one reason for a class to change）。     

该原则提出对象不应该承担太多职责，如果一个对象承担了太多的职责，至少存在以下两个缺点：   
一个职责的变化可能会削弱或者抑制这个类实现其他职责的能力；    
当客户端需要该对象的某一个职责时，不得不将其他不需要的职责全都包含进来，从而造成冗余代码或代码的浪费。   
单一职责原则的优点    
1. 单一职责原则的核心就是控制类的粒度大小、将对象解耦、提高其内聚性。如果遵循单一职责原则将有以下优点。
2. 降低类的复杂度。一个类只负责一项职责，其逻辑肯定要比负责多项职责简单得多。
3. 提高类的可读性。复杂性降低，自然其可读性会提高。
4. 提高系统的可维护性。可读性提高，那自然更容易维护了。
5. 变更引起的风险降低。变更是必然的，如果单一职责原则遵守得好，当修改一个功能时，可以显著降低对其他功能的影响。

### 接口隔离原则

接口隔离原则（Interface Segregation Principle，ISP）要求程序员尽量将臃肿庞大的接口拆分成更小的和更具体的接口，让接口中只包含客户感兴趣的方法。    

2002 年罗伯特·C.马丁给“接口隔离原则”的定义是：客户端不应该被迫依赖于它不使用的方法（Clients should not be forced to depend on methods they do not use）。该原则还有另外一个定义：一个类对另一个类的依赖应该建立在最小的接口上（The dependency of one class to another one should depend on the smallest possible interface）。    

以上两个定义的含义是：要为各个类建立它们需要的专用接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。    

接口隔离原则和单一职责都是为了提高类的内聚性、降低它们之间的耦合性，体现了封装的思想，但两者是不同的：   
1. 单一职责原则注重的是职责，而接口隔离原则注重的是对接口依赖的隔离。
2. 单一职责原则主要是约束类，它针对的是程序中的实现和细节；接口隔离原则主要约束接口，主要针对抽象和程序整体框架的构建。 
接口隔离原则的优点     
接口隔离原则是为了约束接口、降低类对接口的依赖性，遵循接口隔离原则有以下 5 个优点。     
1. 将臃肿庞大的接口分解为多个粒度小的接口，可以预防外来变更的扩散，提高系统的灵活性和可维护性。
2. 接口隔离提高了系统的内聚性，减少了对外交互，降低了系统的耦合性。
3. 如果接口的粒度大小定义合理，能够保证系统的稳定性；但是，如果定义过小，则会造成接口数量过多，使设计复杂化；如果定义太大，灵活性降低，无法提供定制服务，给整体项目带来无法预料的风险。
4. 使用多个专门的接口还能够体现对象的层次，因为可以通过接口的继承，实现对总接口的定义。
5. 能减少项目工程中的代码冗余。过大的大接口里面通常放置许多不用的方法，当实现这个接口的时候，被迫设计冗余的代码。

### 迪米特法则
迪米特法则（Law of Demeter，LoD）又叫作最少知识原则（Least Knowledge Principle，LKP)，产生于 1987 年美国东北大学（Northeastern University）的一个名为迪米特（Demeter）的研究项目，由伊恩·荷兰（Ian Holland）提出，被 UML 创始者之一的布奇（Booch）普及，后来又因为在经典著作《程序员修炼之道》（The Pragmatic Programmer）提及而广为人知。    

迪米特法则的定义是：只与你的直接朋友交谈，不跟“陌生人”说话（Talk only to your immediate friends and not to strangers）。其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。其目的是降低类之间的耦合度，提高模块的相对独立性。   

迪米特法则中的“朋友”是指：当前对象本身、当前对象的成员对象、当前对象所创建的对象、当前对象的方法参数等，这些对象同当前对象存在关联、聚合或组合关系，可以直接访问这些对象的方法。   
迪米特法则的优点     
迪米特法则要求限制软件实体之间通信的宽度和深度，正确使用迪米特法则将有以下两个优点。    
1. 降低了类之间的耦合度，提高了模块的相对独立性。
2. 由于亲合度降低，从而提高了类的可复用率和系统的扩展性。

但是，过度使用迪米特法则会使系统产生大量的中介类，从而增加系统的复杂性，使模块之间的通信效率降低。所以，在釆用迪米特法则时需要反复权衡，确保高内聚和低耦合的同时，保证系统的结构清晰。     

### 合成复用原则
合成复用原则（Composite Reuse Principle，CRP）又叫组合/聚合复用原则（Composition/Aggregate Reuse Principle，CARP）。它要求在软件复用时，要尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。   

如果要使用继承关系，则必须严格遵循里氏替换原则。合成复用原则同里氏替换原则相辅相成的，两者都是开闭原则的具体实现规范。   
合成复用原则的重要性    
通常类的复用分为继承复用和合成复用两种，继承复用虽然有简单和易实现的优点，但它也存在以下缺点。   
1. 继承复用破坏了类的封装性。因为继承会将父类的实现细节暴露给子类，父类对子类是透明的，所以这种复用又称为“白箱”复用。
2. 子类与父类的耦合度高。父类的实现的任何改变都会导致子类的实现发生变化，这不利于类的扩展与维护。
3. 它限制了复用的灵活性。从父类继承而来的实现是静态的，在编译时已经定义，所以在运行时不可能发生变化。

采用组合或聚合复用时，可以将已有对象纳入新对象中，使之成为新对象的一部分，新对象可以调用已有对象的功能，它有以下优点。   
1. 它维持了类的封装性。因为成分对象的内部细节是新对象看不见的，所以这种复用又称为“黑箱”复用。
2. 新旧类之间的耦合度低。这种复用所需的依赖较少，新对象存取成分对象的唯一方法是通过成分对象的接口。
3. 复用的灵活性高。这种复用可以在运行时动态进行，新对象可以动态地引用与成分对象类型相同的对象。

*-------------------------------------希望这是一条你编程之路上的分界线--------------------------------------------*
