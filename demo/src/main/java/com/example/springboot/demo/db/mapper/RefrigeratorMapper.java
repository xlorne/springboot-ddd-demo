package com.example.springboot.demo.db.mapper;

import com.example.springboot.demo.db.domain.Refrigerator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * Update Mapper 是对资源的写操作
 */
@Mapper
public interface RefrigeratorMapper {

  @Insert("INSERT INTO T_REFRIGERATOR(ID,VALUE,TIME,STATE) VALUES (#{id},#{value},#{time},#{state})")
  int save(Refrigerator refrigerator);

  @Update("UPDATE T_REFRIGERATOR SET VALUE = #{value},TIME=#{time},STATE=1 WHERE ID = #{id}")
  int updateValue(Refrigerator refrigerator);

  @Update("TRUNCATE T_REFRIGERATOR")
  void truncate();

}
