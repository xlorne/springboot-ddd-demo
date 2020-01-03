package com.example.springboot.demo.mapper;

import com.example.springboot.demo.domain.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Mapper
public interface LogMapper {

    @Insert("insert into t_test(id,name) values (#{id},#{name})")
    int save(Log log);

}
