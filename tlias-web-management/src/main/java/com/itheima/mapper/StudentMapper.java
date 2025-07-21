package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> findAll(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void deleteStudentById(Integer id);

    @MapKey("Map")
    List<Map<String, Object>> getStudentData();

    @MapKey("Map")
    List<Map> countDegreeData();
}
