package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogMapper empLogMapper;


    // -------------------原始分页查询方式------------------
//    @Override
//    public Long count() {
//        return empMapper.count();
//    }
//
//    @Override
//    public PageResult<Emp> list(Integer page, Integer pageSize) {
//        //1. 获取总记录
//        Long total = empMapper.count();
//
//        //2. 获取结果列表
//        Integer start = (page - 1) * pageSize;  //根据页号计算出起始数据编号
//        List<Emp> empList = empMapper.list(start, pageSize);
//
//        //3. 封装结果
//        return new PageResult<Emp>(total, empList);
//    }

    // -------------------利用pageHelper插件实现分页查询------------------
//    public PageResult<Emp> list(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        //1. 设置分页参数
//        PageHelper.startPage(page, pageSize);
//
//        //2. 执行查询
//        List<Emp> empList = empMapper.list(name, gender, begin, end);
//
//        //3. 解析查询结果，并进行封装
//        Page<Emp> p = (Page<Emp>) empList;
//        return new PageResult<Emp>(p.getTotal(), p.getResult());
//    }

    @Override
    public PageResult<Emp> list(EmpQueryParam empQueryParam) {
        //1. 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //2. 执行查询
        List<Emp> empList = empMapper.fuck(empQueryParam);

        //3. 解析查询结果，并进行封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try{
            //1. 保存员工基本信息
            emp.setCreateTime(LocalDate.now());
            emp.setUpdateTime(LocalDate.now());
            empMapper.insert(emp);

            //2. 保存员工工作经历信息
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
//            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
                for (EmpExpr expr : exprList) {  // 遍历员工的工作经历集合
                    expr.setEmpId(empId);     // 将当前员工的ID注入工作经历对象
                }
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogMapper.insertLog(empLog);
        }
    }

    @Override
    public void delete(List<Integer> deleteIdList) {
        //1. 批量删除员工信息
        empMapper.deleteById(deleteIdList);

        //2. 批量删除员工工作经历
        empExprMapper.deleteExprById(deleteIdList);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getInfo(id);
    }

    @Override
    public void update(Emp emp) {
        Integer empId = emp.getId();

        //1. 更新员工基本信息
        empMapper.updateById(emp);

        //2. 删除原先员工经历
        List<Integer> deleteIdList = List.of(empId);
        empExprMapper.deleteExprById(deleteIdList);

        //3. 添加最新员工经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            for (EmpExpr expr : exprList) {
                expr.setEmpId(empId);
            }
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Map<Integer, String>> listAllEmpName() {
        return empMapper.listAllEmpName();
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getUsernameAndPassword(emp);
        if (empLogin != null) {
            //生成Jwt令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", empLogin.getId());
            claims.put("username", empLogin.getUsername());
            String jwtToken = JwtUtils.generateToken(claims);
            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), jwtToken);
            return loginInfo;
        }
        return null;
    }
}
