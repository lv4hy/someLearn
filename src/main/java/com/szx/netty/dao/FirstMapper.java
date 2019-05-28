package com.szx.netty.dao;

import com.szx.netty.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FirstMapper {
    @Select("select * from test where id = 1")
    Student selectOneById(int id);
}
