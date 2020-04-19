/**
 * service 层
 * 业务适配调用层，这与三层架构的业务层差别较大，该service主要是做对vo数据的适配处理以及executor层的协调调用。
 *
 * service层需要做的事情:
 * 1、事务的开启
 * 2、调用Executor层逻辑。
 * 3、业务的拓展，业务拓展是在service层适配。
 * 4、多个Executor层的编排。
 *
 *
 * Executor层代表的是不同的业务指令，但是在某些业务中需要的是两次执行的执行。这样的逻辑就在Service层完成。
 *
 * @author lorne
 * @date 2020/2/10
 */
package com.example.springboot.demo.service;