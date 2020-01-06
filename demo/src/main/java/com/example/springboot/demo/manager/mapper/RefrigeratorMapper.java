package com.example.springboot.demo.manager.mapper;

import com.example.springboot.demo.manager.domain.Refrigerator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * Update Mapper 是对资源的写操作
 *
 */
@Mapper
public interface RefrigeratorMapper {

    @Insert("insert into t_refrigerator(id,value,time,state) values (#{id},#{value},#{time},#{state})")
    int save(Refrigerator refrigerator);

    @Update("update t_refrigerator set value = #{value},time=#{time},state=1 where id = #{id}")
    int updateValue(@Param("value") String value, @Param("time")Date time,@Param("id") int id);

    @Update("truncate t_refrigerator")
    void truncate();

}
