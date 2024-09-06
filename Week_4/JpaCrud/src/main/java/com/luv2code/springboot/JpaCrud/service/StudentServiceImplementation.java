package com.luv2code.springboot.JpaCrud.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.JpaCrud.dao.*;
import com.luv2code.springboot.JpaCrud.entity.*;

@Service
public class StudentServiceImplementation implements StudentService{
	
	// Define field for StudentDao
    private final StudentDao studentDao;

    // Constructor injection for StudentDao
    @Autowired
    public StudentServiceImplementation(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    // Fetch all students
    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    // Save or update a student
    @Override
    public Student save(Student theStudent) {
        return studentDao.save(theStudent);
    }

    // Find students who passed (average >= 70)
    @Override
    public List<Student> findPassStudents() {
        return studentDao.findAllStudents().stream()
            .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) >= 0)
            .collect(Collectors.toList());
    }

    // Delete student by ID
    @Override
    public void deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
    }

    // Find students who failed (average < 70)
    @Override
    public List<Student> findFailStudents() {
        return studentDao.findAllStudents().stream()
            .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) < 0)
            .collect(Collectors.toList());
    }
	

}
