package com.example.springboot.core.framework;


import java.io.Serializable;

/**
 * BizContext 是定义业务的全局数据
 *
 * 在RPC操作时会传递该对象，因此需要支持序列化
 * 没有具体的接口要求，完全由业务方来定义
 */
public interface BizContext extends Serializable{

}
