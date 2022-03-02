package com.chilly.service;
import com.chilly.entity.Student;

import java.util.List;

public interface StudentService {

    Student find(Student stu);

    void save(Student stu);
}
