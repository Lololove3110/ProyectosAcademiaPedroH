package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	List<Student> findAllStudents();
    Student save(Student theStudent);
    List<Student> findPassStudents();
    void deleteStudentById(int id); 
    List<Student> findFailStudents(); 

 
}
