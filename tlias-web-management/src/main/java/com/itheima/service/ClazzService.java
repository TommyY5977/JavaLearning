package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClazzService {
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    public void addClazz(Clazz clazz);

    public Clazz getClazzById(@RequestParam(required = false) Integer id);

    public void modifyClazz(@RequestBody Clazz clazz);

    public void deleteClazzById(Integer id);

    public List<Clazz> getAllClazzInfo();
}
