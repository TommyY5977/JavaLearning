package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/*
* 员工管理Controller
* */
//@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);
    @Autowired
    private EmpService empService;

    //分页查询
//    @RequestMapping(method = RequestMethod.GET)
//    public Result list(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end) {
//        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.list(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }


    //优化
    @RequestMapping(method = RequestMethod.GET)
    public Result list(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult<Emp> pageResult = empService.list(empQueryParam);
        return Result.success(pageResult);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Emp emp) {
        log.info("插入员工数据：{}", emp);
        empService.save(emp);
        return Result.success();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Result delete(@RequestParam("ids") List<Integer> deleteIdList) {
        log.info("删除员工id：{}", deleteIdList);
        empService.delete(deleteIdList);
        return Result.success();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据id查询员工的详细信息");
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody Emp emp) {
        emp.setUpdateTime(LocalDate.now());
        log.info("修改员工信息：{}", emp);
        empService.update(emp);
        return Result.success();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result listAllEmp() {
        log.info("查询所有员工");
        List<Map<Integer, String>> list = empService.listAllEmpName();
        return Result.success(list);
    }
}
