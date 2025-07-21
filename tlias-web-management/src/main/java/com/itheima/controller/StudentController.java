package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @GetMapping()
    public Result getStudentData(StudentQueryParam studentQueryParam) {
        log.info("查询所有学生信息");
        PageResult<Student> list = studentService.findAll(studentQueryParam);
        return Result.success(list);
    }

    @PostMapping()
    public Result addStudent(@RequestBody Student student) {
        student.setUpdateTime(LocalDate.now());
        student.setUpdateTime(LocalDate.now());
        student.setViolationCount(0);
        student.setViolationScore(0);
        log.info("添加学生信息：{}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping(value = "/{id}")
    public Result getStudentById(@PathVariable Integer id) {
        log.info("查询id为：{}的学生信息", id);
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }

    @DeleteMapping(value = "/{id}")
    public Result deleteStudentById(@PathVariable Integer id) {
        log.info("删除id为{}的学生信息", id);
        studentService.deleteStudentById(id);
        return Result.success();
    }
}
