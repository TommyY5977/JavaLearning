package com.itheima.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ClazzQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer room;
    private Integer master; //班主任
    private String subject; //学科
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime; //课程创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateTime; //结束时间

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

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ClazzQueryParam{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", room=" + room +
                ", master=" + master +
                ", subject='" + subject + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
