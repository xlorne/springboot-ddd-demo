package com.example.springboot.demo.domain;

/**
 * @author lorne
 * @date 2020/1/26
 * @description
 */
public interface DomainFactoryI <T extends DomainObject>  {

    T create(Class<T> clazz,Object ... initargs);

}
