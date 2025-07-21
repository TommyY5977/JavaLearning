package com.itheima.controller;

import com.itheima.anno.LogOperation;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/clazzs")
public class ClazzController {
    private static final Logger log = LoggerFactory.getLogger(ClazzController.class);
    @Autowired
    private ClazzService clazzService;

    @LogOperation
    @RequestMapping(method = RequestMethod.GET)
    public Result getClazzData(ClazzQueryParam clazzQueryParam) {
        log.info("查询所有班级信息: {}", clazzQueryParam);
        PageResult<Clazz> list = clazzService.findAll(clazzQueryParam);
        return Result.success(list);
    }

    @LogOperation
    @RequestMapping(method = RequestMethod.POST)
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("添加课程：{}", clazz);
        clazz.setUpdateTime(LocalDate.now());
        clazzService.addClazz(clazz);
        return Result.success();
    }

    @LogOperation
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Result getClazzById(@PathVariable Integer id) {
        log.info("查询id为：{}的班级信息", id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }


    //修改班级信息
    @LogOperation
    @RequestMapping(method = RequestMethod.PUT)
    public Result modifyClazz(@RequestBody Clazz clazz) {
        log.info("修改信息：{}", clazz);
        clazzService.modifyClazz(clazz);
        return Result.success();
    }

    //删除班级信息
    @LogOperation
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public Result deleteClazzById(@PathVariable Integer id) {
        log.info("删除id为{}的班级信息", id);
        clazzService.deleteClazzById(id);
        return Result.success();
    }

    @LogOperation
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result getAllCLazzInfo() {
        log.info("获取所有班级信息");
        List<Clazz> allClazzInfo = clazzService.getAllClazzInfo();
        return Result.success(allClazzInfo);
    }
}
