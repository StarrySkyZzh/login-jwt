package com.chilly.service;

import com.chilly.entity.Student;
import com.chilly.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student find(Student stu) {
          return studentDao.find(stu);
    }

    @Override
    public void save(Student stu) {
        studentDao.save(stu);
    }

}
