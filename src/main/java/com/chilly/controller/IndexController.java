package com.chilly.controller;

import com.chilly.entity.Student;
import com.chilly.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class IndexController {

    @Autowired
    StudentService studentService;

    @GetMapping("/index")
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

    @PostMapping("/save")
    public void save(Student stu,HttpServletResponse response){
        log.info("修改用户名:{}",stu.getName());
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
}
