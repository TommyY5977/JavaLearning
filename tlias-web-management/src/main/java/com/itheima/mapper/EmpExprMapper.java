package com.itheima.mapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
* 员工工作经历操作
* */

@Mapper
public interface EmpExprMapper {
    public void insertBatch(List<EmpExpr> empExprList);

    public void deleteExprById(List<Integer> deleteIdList);
}
