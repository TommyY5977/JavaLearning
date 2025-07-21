package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    public List<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    public void addClazz(Clazz clazz);

    public Clazz getClazzById(Integer id);

    public void modifyClazz(Clazz clazz);

    public void deleteClazzById(Integer id);

    public Integer countStudentsByClazzId(Integer id);

    public List<Clazz> getAllClazzInfo();
}
