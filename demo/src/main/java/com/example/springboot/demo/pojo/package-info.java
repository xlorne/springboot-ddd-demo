package com.example.springboot.demo.pojo;


/**
 *
 * POJO 分为VO AO VIEW/Entity/Domain 这不同的包名。
 * vo ao view/entity/domain 又分因为四层架构分为三层分别是:
 *
 * controller->service=>vo, service->manager=>ao, manager->db=>view/entity/domain
 *
 * 依赖关系说明:
 * vo->ao->db(view/entity/domain)
 *
 * 不可逆向(错误示范):
 * vo<-ao<-db(view/entity/domain)
 *
 * 各层的功能作用说明:
 * VO     用于Controller层传递数据使用，通常也会添加swagger、validation 注解，作为接口展示与数据校验使用。
 * AO     用于Service层数据调用Manager层使用，该对象只允许出现在Manager层处理业务上。
 * VIEW   用于DB层处理数据上，该对象只能使用用DB层，往往是数据库视图的数据组装处理。
 * Entity 用于DB层定义数据库表字段上，通常会使用JPA框架直接对类做数据库表关联。
 * Domain 用于DB层定义数据库表字段上，通常会使用Mybatis框架直接对类做数据库表关联。
 *
 * VO/AO/db 命名规范:
 * VO   根据方法来区分，并且由于分为请求和相应，比如添加用户 UserReq UserRes，格式分为XXXReq XXXRes。
 * AO   根据数据来区分，比如存在用户的那些信息，可以命名为UserInfo,若其字段与数据库表字段完全匹配可以直接集成。
 * DB   根据表数据来区分，entity/domain完全与表一一对应的，view 也分为相应数据与条件数据，对于试图数据后缀会写XXXView,例如UserView,查询条件XXXXParam例如UserParam。
 *
 * 各层之间的转换关系:
 * vo->(ao,db)  vo层可通过方法直接转换成ao、db层的对象。
 * ao->db       ao层可通过方法直接转换成db成的对象。
 *
 *
 * Manager层规范要求
 *
 * 1、 Service层传入传出是vo对象，因此在调用Manager层是必然会根据Manager的业务转换成ao对象，然后开始执行业务。
 * 2、 Manager层只允许在大领域下调用小领域，和本领域内部方法调用，若划分了小领域后，那么各个小领域之间也不可互相调用，领域层是不允许夸领域间的调用，这应该是Service层控制的。
 * 3、 Manager只允许两类参数形式:1、使用ao对象转换；2、直接引用所有参数。
 * 4、 若该ao对象只是在某一个子领域业务上使用时，可以将ao以匿名内部类的形式在manager上定义。
 * 5、 依赖关系说明中也提到了ao层的对象不允许传递到db层使用，这也表明了db层公开的方法只能是view/entity/domain层的数据对象。
 *
 */
