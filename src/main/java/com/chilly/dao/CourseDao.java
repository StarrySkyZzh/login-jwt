package com.chilly.dao;

import com.chilly.entity.Course;
import com.chilly.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {

    List<Course> find(Course cou);

    void commit(Course course);

    Course FindTopic(Course course);

    void ResetScore();

    void add(Course course);

    void edit(Course course);

    void delete(Course course);

    void AfterDelete(Course course);
}
