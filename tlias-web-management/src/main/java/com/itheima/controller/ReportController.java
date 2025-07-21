package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/report")
@RestController
public class ReportController {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/empJobData", method = RequestMethod.GET)
    public Result getEmpJobData() {
        log.info("统计各职位员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @RequestMapping(value = "/empGenderData", method = RequestMethod.GET)
    public Result getEmpGenderData() {
        log.info("统计员工男女比例");
        List<Map> genderOption = reportService.getEmpGenderData();
        return Result.success(genderOption);
    }

    @RequestMapping(value = "/studentCountData", method = RequestMethod.GET)
    public Result getStudentCountData() {
        log.info("统计班级人数");
        JobOption clazzData= reportService.getClazzData();
        return Result.success(clazzData);
    }

    @RequestMapping(value = "/studentDegreeData", method = RequestMethod.GET)
    public Result getStudentDegreeData() {
        log.info("统计学生学位信息");
        List<Map> studentOption = reportService.getDegreeData();
        return Result.success(studentOption);
    }
}
