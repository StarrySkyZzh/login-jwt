package com.chilly.service;

import com.chilly.dao.TeacherDao;
import com.chilly.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher find(Teacher teacher) {
        return teacherDao.find(teacher);
    }

    @Override
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }
}
