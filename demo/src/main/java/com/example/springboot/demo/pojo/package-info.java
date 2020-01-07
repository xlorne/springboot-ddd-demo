package com.example.springboot.demo.pojo;

/***
 *
 * pojo 分为vo dto
 * vo 代表的是controller层的req res对象。
 * dto 则是manager与manager之前的数据传输对象。
 *
 * pojo 仅仅是entity的一些bean操作，由于项目中的对象比较多会出现各种类型的转换，当需要转换的时候也是直接在entity上来做的。
 * pojo 将负责完成所有的entity的转换操作，但仅限于pojo层中的对象。
 *
 */
