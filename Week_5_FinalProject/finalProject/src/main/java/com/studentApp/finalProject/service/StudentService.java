package com.studentApp.finalProject.service;

import java.util.List;
import com.studentApp.finalProject.entity.Student;

public interface StudentService {
    List<Student> findAllStudents();
    Student save(Student theStudent);
    List<Student> findPassStudents();
    void deleteStudentById(int id); 
    List<Student> findFailStudents();
}
