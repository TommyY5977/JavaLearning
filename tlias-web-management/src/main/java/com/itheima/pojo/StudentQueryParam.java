package com.itheima.pojo;

public class StudentQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer degree;
    private Integer clazzId;

    public StudentQueryParam(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId) {
        this.page = page;
        this.pageSize = pageSize;
        this.name = name;
        this.degree = degree;
        this.clazzId = clazzId;
    }

    public StudentQueryParam() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }
}
