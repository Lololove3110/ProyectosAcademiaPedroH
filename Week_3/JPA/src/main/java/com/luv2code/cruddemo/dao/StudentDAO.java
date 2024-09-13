package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

	// Save a student
    void save(Student theStudent);

    // Find a student by ID
    Student findById(Integer id);

    // Find all students
    List<Student> findAll();

    // Find students by last name
    List<Student> findByLastName(String lastName);

    // Update an existing student
    void update(Student theStudent);

    // Delete a student by ID
    void delete(Integer id);

    // Delete all students
    int deleteAll();
}
