package com.obs.servlet;

import com.obs.model.Department;
import com.obs.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "homeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Student> students = inquiryStudentsOrderByDepartmentAndStudentId();
        request.setAttribute("students", students);
        List<Department> departments = new ArrayList<>();

        String lastDepartment = "";
        List<Student> departmentStudents = new ArrayList<>();
        for(int i=0;i<students.size();i++){
            if(i==0){
                departmentStudents = new ArrayList<>();
                lastDepartment = students.get(i).getDepartment();
            }

            if(i==students.size()-1){
                departmentStudents.add(students.get(i));
            }

            if(!students.get(i).getDepartment().equals(lastDepartment) || i == students.size()-1){
                int passedStudents = 0;
                for(Student student : departmentStudents){
                    if(student.getMark()>=40){
                        passedStudents++;
                    }
                }
                departments.add(new Department(lastDepartment, departmentStudents, (passedStudents/(departmentStudents.size()+0.0)*100)));
                departmentStudents = new ArrayList<>();
            }

            departmentStudents.add(students.get(i));
            lastDepartment = students.get(i).getDepartment();
        }

        request.setAttribute("departments", departments);

        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }

    public List<Student> inquiryStudentsOrderByDepartmentAndStudentId(){
        //fake inquiry to DB
        List<Student> students = new ArrayList<>();
        String dep1 = "Dep 1";
        String dep2 = "Dep 2";
        String dep3 = "Dep 3";
        students.add(new Student("S1","Axel",35,dep1));
        students.add(new Student("S2","Theola",70,dep1));
        students.add(new Student("S3","Peter",60,dep1));
        students.add(new Student("S4","Nathaniel",90,dep1));
        students.add(new Student("S5","Loren",30,dep2));
        students.add(new Student("S6","Kody",32,dep3));
        students.add(new Student("S7","Dave",70,dep3));
        students.add(new Student("S8","Reta",20,dep3));

        return students;
    }
}