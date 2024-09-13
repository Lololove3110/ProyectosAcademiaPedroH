package com.studentApp.finalProject.service;

import com.studentApp.finalProject.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(int id);
    void saveStudent(Student student);
    boolean deleteStudentById(int id);

    // These methods still make sense because we are filtering based on database values
    List<Student> findPassStudents();
    List<Student> findFailStudents();
}
