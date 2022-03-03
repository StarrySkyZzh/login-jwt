package com.chilly.service;

import com.chilly.entity.Course;
import com.chilly.entity.Score;

import java.util.List;

public interface CourseService{

    List<Course> find(Course course);

    void commit(Course course);

    Course FindTopic(Course course);

    void ResetScore();

    void add(Course course);

    void edit(Course course);

    void delete(Course course);

    void AfterDelete(Course course);
}
