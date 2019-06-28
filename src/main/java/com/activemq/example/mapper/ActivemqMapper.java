package com.activemq.example.mapper;

import com.activemq.example.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivemqMapper {

    Integer updateTeacherNameById(Long id);
    Teacher selectTeacherById(Long id);
    Integer updateTeacherNameForStu(Teacher teacher);
}
