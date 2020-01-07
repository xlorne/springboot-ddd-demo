package com.example.springboot.demo.manager.mapper;

import com.example.springboot.demo.manager.domain.Refrigerator;
import java.util.Date;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Update Mapper 是对资源的写操作
 */
@Mapper
public interface RefrigeratorMapper {

  @Insert("INSERT INTO T_REFRIGERATOR(ID,VALUE,TIME,STATE) VALUES (#{id},#{value},#{time},#{state})")
  int save(Refrigerator refrigerator);

  @Update("UPDATE T_REFRIGERATOR SET VALUE = #{value},TIME=#{time},STATE=1 WHERE ID = #{id}")
  int updateValue(@Param("value") String value, @Param("time") Date time, @Param("id") int id);

  @Update("TRUNCATE T_REFRIGERATOR")
  void truncate();

}
