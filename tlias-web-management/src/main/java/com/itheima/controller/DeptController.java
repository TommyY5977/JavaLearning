package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//@Slf4j
@RequestMapping(value = "/depts")
@RestController
public class DeptController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @RequestMapping(method = RequestMethod.GET)
    public Result list() {
        log.info("查询所有部门数据");
       List<Dept> deptList = deptService.findAll();
       return Result.success(deptList);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Result delete(@RequestParam("id") Integer id) {
        log.info("根据id删除部门：" + id);
//        System.out.println("根据id删除部门：" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    // 新增部门
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：" + dept);
//        System.out.println("新增部门：" + dept);
        deptService.add(dept);
        return Result.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getById(@PathVariable Integer id) {
        log.info("查询部门：" + id);
//        System.out.println("查询部门：" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        log.info("修改部门数据：" + dept);
//        System.out.println("修改部门数据：" + dept);
        deptService.update(dept);
        return Result.success(dept);
    }
}
