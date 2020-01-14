package com.example.springboot.demo.db.mapper;

import com.example.springboot.core.db.entity.Refrigerator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Query Mapper 是对资源的读操作，方便当数据量大了以后的读写分离优化。
 */
@Mapper
public interface RefrigeratorQuery {

  @Select("SELECT * FROM T_REFRIGERATOR WHERE STATE = 0 LIMIT 1 ")
  Refrigerator findSpace();


}
