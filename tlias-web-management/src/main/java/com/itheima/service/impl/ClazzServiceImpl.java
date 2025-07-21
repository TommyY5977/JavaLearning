package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.findAll(clazzQueryParam);
//        clazzList.forEach(c -> {
//            System.out.println("Master: " + c.getMasterName()); // 检查是否为 null
//        });
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    @Override
    public void modifyClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDate.now());
        clazzMapper.modifyClazz(clazz);
    }

    public void deleteClazzById(Integer id) {
        Integer relateStudentCount = clazzMapper.countStudentsByClazzId(id);
        if (relateStudentCount > 0) {
            throw new RuntimeException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.deleteClazzById(id);
    }

    public List<Clazz> getAllClazzInfo() {
        return clazzMapper.getAllClazzInfo();
    }
}
