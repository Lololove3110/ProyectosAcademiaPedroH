package com.luv2code.springboot.JpaCrud.service;

import java.util.List;

import com.luv2code.springboot.JpaCrud.entity.Student;

public interface StudentService {
	List<Student> findAllStudents();
    Student save(Student theStudent);
    List<Student> findPassStudents();
    void deleteStudentById(int id); 
    List<Student> findFailStudents(); 

}
