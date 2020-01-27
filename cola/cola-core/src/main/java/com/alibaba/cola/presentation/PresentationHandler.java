package com.alibaba.cola.presentation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface PresentationHandler {

}
