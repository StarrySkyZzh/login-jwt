package com.chilly.service;

import com.chilly.dao.CourseDao;
import com.chilly.entity.Course;
import com.chilly.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> find(Course course) {
        return courseDao.find(course);
    }

    @Override
    public void commit(Course course) {
        courseDao.commit(course);
    }

    @Override
    public Course FindTopic(Course course) {
        return courseDao.FindTopic(course);
    }

    @Override
    public void ResetScore() {
        courseDao.ResetScore();
    }

    @Override
    public void add(Course course) {
        courseDao.add(course);
    }

    @Override
    public void edit(Course course) {
        courseDao.edit(course);
    }

    @Override
    public void delete(Course course) {
        courseDao.delete(course);
        courseDao.AfterDelete(course);
    }

    @Override
    public void AfterDelete(Course course) {
        courseDao.AfterDelete(course);
    }
}
