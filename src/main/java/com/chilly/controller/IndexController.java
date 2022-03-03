package com.chilly.controller;

import com.chilly.entity.Student;
import com.chilly.entity.Teacher;
import com.chilly.service.StudentService;
import com.chilly.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@Api(tags = "用户界面相关接口")
@Slf4j
public class IndexController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/student/index")
    @ApiOperation("查询用户信息的接口")
    public void index(Student stu, HttpServletResponse response) {

        log.info("用户名：{}", stu.getName());

        Student login = studentService.find(stu);
        log.info("显示用户：{}",login.getName());
        JSONObject json = new JSONObject().fromObject(login);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/student/save")
    @ApiOperation("更改用户信息的接口")
    public void save(Student stu, HttpServletResponse response){
        log.info("修改用户id:{}",stu.getIid());
        studentService.save(stu);
        JSONObject json = new JSONObject().fromObject(studentService.find(stu));
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/teacher/index")
    @ApiOperation("查询用户信息的接口")
    public void index(Teacher teacher, HttpServletResponse response) {

        log.info("用户名：{}", teacher.getName());

        Teacher login = teacherService.find(teacher);
        log.info("显示用户：{}",login.getName());
        JSONObject json = new JSONObject().fromObject(login);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/teacher/save")
    @ApiOperation("更改用户信息的接口")
    public void save(Teacher teacher, HttpServletResponse response){
        log.info("修改用户id:{}",teacher.getIid());
        teacherService.save(teacher);
        JSONObject json = new JSONObject().fromObject(teacherService.find(teacher));
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
