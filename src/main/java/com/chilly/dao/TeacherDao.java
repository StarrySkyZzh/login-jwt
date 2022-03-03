package com.chilly.dao;

import com.chilly.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherDao {
    Teacher find(Teacher teacher);

    void save(Teacher teacher);
}
