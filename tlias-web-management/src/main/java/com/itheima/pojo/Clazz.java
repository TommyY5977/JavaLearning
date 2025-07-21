package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Clazz {
    private Integer id;
    private String masterName;
    private Integer masterId;
    private String name;
    private Integer room;
    private String subject;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateTime;

    public Clazz() {
    }

    public Clazz(Integer id, Integer masterId, String name, Integer room, String subject, String status, LocalDate beginDate, LocalDate endDate, LocalDate createTime, LocalDate updateTime) {
        this.id = id;
        this.masterId = masterId;
        this.name = name;
        this.room = room;
        this.subject = subject;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Clazz(Integer id, LocalDate beginDate, LocalDate createTime, String masterName, LocalDate endDate, String name, Integer room, String subject, LocalDate updateTime, String status) {
        this.id = id;
        this.beginDate = beginDate;
        this.createTime = createTime;
        this.masterName = masterName;
        this.endDate = endDate;
        this.name = name;
        this.room = room;
        this.subject = subject;
        this.updateTime = updateTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }
}
