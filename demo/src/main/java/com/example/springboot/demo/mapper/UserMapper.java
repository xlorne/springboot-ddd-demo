package com.example.springboot.demo.mapper;

import com.example.springboot.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Mapper
public interface UserMapper {

    @Insert("insert into t_demo(id,name) values (#{id},#{name})")
    int save(User user);

}
