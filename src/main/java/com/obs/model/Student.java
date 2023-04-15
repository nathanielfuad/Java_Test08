package com.obs.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String studentId;
    private String name;
    private int mark;
    private String department;

    public Student(){}

    public Student(String studentId, String name, int mark, String department) {
        this.studentId = studentId;
        this.name = name;
        this.mark = mark;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
