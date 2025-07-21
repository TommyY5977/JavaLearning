package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

public interface StudentService {
    public PageResult<Student> findAll(StudentQueryParam studentQueryParam);

    public void addStudent(Student student);

    public Student getStudentById(Integer id);

    public void deleteStudentById(Integer id);
}
