package com.luv2code.springboot.JpaCrud.dao;

import java.util.List;

import com.luv2code.springboot.JpaCrud.entity.*;

public interface StudentDao {
	
	List<Student> findAllStudents();
    Student save(Student theStudent);
    List<Student> findPassStudents();
    void deleteStudentById(int id); 
    List<Student> findFailStudents(); 

}
