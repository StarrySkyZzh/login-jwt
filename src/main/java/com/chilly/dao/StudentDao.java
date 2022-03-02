package com.chilly.dao;

import com.chilly.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {

    Student find(Student stu);

    void save(Student stu);
}
