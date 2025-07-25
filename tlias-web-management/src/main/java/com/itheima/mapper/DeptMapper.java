package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {
    /*
    * 查询所有部门
    * */
//    @Results({
//        @Result(column = "create_time", property = "createTime"),
//        @Result(column = "update_time", property = "updateTime")
//    })
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    public List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);

    //向dept表中根据name等数据插入信息
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    public void insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    public Dept getById(Integer id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    public void update(Dept dept);
}
