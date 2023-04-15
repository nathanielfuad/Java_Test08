package com.obs.model;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {
    private String name;
    private List<Student> students;
    private double pass;
    public Department() {
    }

    public Department(String name, List<Student> students, double pass) {
        this.name = name;
        this.students = students;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public double getPass() {
        return pass;
    }

    public void setPass(double pass) {
        this.pass = pass;
    }
}
