package com.chilly.service;

import com.chilly.entity.Teacher;

public interface TeacherService {

    Teacher find(Teacher teacher);

    void save(Teacher teacher);
}
