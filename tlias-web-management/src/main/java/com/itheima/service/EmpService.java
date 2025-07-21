package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmpService {
//    public Long count();

    public PageResult<Emp> list(EmpQueryParam empQueryParam);

    public void save(Emp emp);

    public void delete(List<Integer> deleteIdList);

    public Emp getInfo(Integer id);

    public void update(Emp emp);

    public List<Map<Integer, String>> listAllEmpName();

    public LoginInfo login(Emp emp);
}
