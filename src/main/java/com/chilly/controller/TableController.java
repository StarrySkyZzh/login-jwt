package com.chilly.controller;
import com.chilly.entity.Course;
import com.chilly.entity.Score;
import com.chilly.entity.Student;
import com.chilly.service.CourseService;
import com.chilly.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "用户操作管理相关接口")
@Slf4j
public class TableController {

    public String Time;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/work")
    @ApiOperation("显示学生考题")
    public void work(Course course, HttpServletResponse response){
        List<Course> list = courseService.find(course);
        JSONArray json = new JSONArray().fromObject(list);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/work/start")
    @ApiOperation("开始考试")
    public void start(){
        courseService.ResetScore();
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        Time=dateFormat.format(calendar.getTime());
        log.info("时间:{}",Time);
    }

    @PostMapping("/work/commit")
    @ApiOperation("作答")
    public void commit(Course course,HttpServletResponse response){
        courseService.commit(course);
        Course ChangeCourse = courseService.FindTopic(course);
        JSONObject json = new JSONObject().fromObject(ChangeCourse);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/work/end")
    @ApiOperation("结束考试")
    public void end(@Param("timess") String timess,HttpServletResponse response){
        timess=Time;
        scoreService.sum(timess);
        List<Score> list = scoreService.find();
        JSONArray json = new JSONArray().fromObject(list);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/teacher/show")
    public void show(HttpServletResponse response){
        List<Score> list = scoreService.find();
        JSONArray json = new JSONArray().fromObject(list);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/teacher/add")
    public void add(Course course){
        courseService.add(course);
        log.info("新增题目序号：{}",course.getId());
    }

    @PostMapping("/teacher/edit")
    public void edit(Course course){
        log.info("编辑题目序号：{}",course.getId());
        courseService.edit(course);
    }

    @PostMapping("/teacher/delete")
    public void delete(Course course){
        log.info("删除题目序号：{}",course.getId());
        courseService.delete(course);
    }
}
