package com.itheima.mapper;

/*
* 操作员工基本信息
* */

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    // ----------------------------原始分页查询实现------------------------------
//    //查询总数
//    @Select("select COUNT(*) from emp e left join dept d on d.id = e.dept_id")
//    public Long count();
//
//    //分页查询
//    @Select("select e.*, d.name deptName from emp e left join dept d on d.id = e.dept_id " +
//            "order by update_time limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    // ----------------------利用pageHelper插件实现分页查询-----------------------
//    @Select("select e.*, d.name deptName from emp e left join dept d on d.id = e.dept_id order by update_time")
//    public List<Emp> list();

    // ------------------------------实现条件查询--------------------------------
//    @Select("""
//    SELECT e.*, d.name deptName
//    FROM emp e
//    LEFT JOIN dept d ON d.id = e.dept_id
//    WHERE e.name LIKE CONCAT('%', #{name}, '%')
//      AND e.gender = #{gender}
//      AND e.entry_date BETWEEN #{begin} AND #{end}
//    ORDER BY e.update_time
//    """)
    public List<Emp> fuck(EmpQueryParam empQueryParam);

    public void insert(Emp emp);

    public void deleteById(List<Integer> deleteIdList);

    public Emp getInfo(Integer id);

    public void updateById(Emp emp);

    @MapKey("Map")
    List<Map<String, Object>> countEmpIdData();

    @MapKey("Map")
    List<Map> countGenderData();

    List<Map<Integer, String>> listAllEmpName();

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}
