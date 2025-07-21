package com.itheima.pojo;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String address;
    private Integer clazzId;
    private String clazzName;
    private LocalDate createTime;
    private Integer degree;
    private Integer gender;
    private LocalDate graduationDate;
    private String idCard;
    private boolean isCollege;
    private String name;
    private String no;
    private String phone;
    private LocalDate updateTime;
    private Integer violationCount;
    private Integer violationScore;

    public Student() {
    }

    public Student(Integer id, String address, String clazzName, LocalDate createTime, Integer degree, Integer gender, LocalDate graduationDate, String idCard, boolean isCollege, String name, String no, String phone, LocalDate updateTime, Integer violationCount, Integer violationScore) {
        this.id = id;
        this.address = address;
        this.clazzName = clazzName;
        this.createTime = createTime;
        this.degree = degree;
        this.gender = gender;
        this.graduationDate = graduationDate;
        this.idCard = idCard;
        this.isCollege = isCollege;
        this.name = name;
        this.no = no;
        this.phone = phone;
        this.updateTime = updateTime;
        this.violationCount = violationCount;
        this.violationScore = violationScore;
    }

    public Student(Integer id, String address, Integer clazzId, LocalDate createTime, Integer degree, Integer gender, LocalDate graduationDate, String idCard, boolean isCollege, String name, String no, String phone, LocalDate updateTime, Integer violationCount, Integer violationScore) {
        this.id = id;
        this.address = address;
        this.clazzId = clazzId;
        this.createTime = createTime;
        this.degree = degree;
        this.gender = gender;
        this.graduationDate = graduationDate;
        this.idCard = idCard;
        this.isCollege = isCollege;
        this.name = name;
        this.no = no;
        this.phone = phone;
        this.updateTime = updateTime;
        this.violationCount = violationCount;
        this.violationScore = violationScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isCollege() {
        return isCollege;
    }

    public void setCollege(boolean college) {
        isCollege = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(Integer violationCount) {
        this.violationCount = violationCount;
    }

    public Integer getViolationScore() {
        return violationScore;
    }

    public void setViolationScore(Integer violationScore) {
        this.violationScore = violationScore;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }
}
