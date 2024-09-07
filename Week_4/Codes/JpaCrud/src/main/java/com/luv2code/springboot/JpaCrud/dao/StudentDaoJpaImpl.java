package com.luv2code.springboot.JpaCrud.dao;

import com.luv2code.springboot.JpaCrud.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;



@Repository
public class StudentDaoJpaImpl implements StudentDao{
	
	private final EntityManager entityManager;

    // Constructor injection for EntityManager
    @Autowired
    public StudentDaoJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    // Fetch all students
    @Override
    public List<Student> findAllStudents() {
        // Create query to fetch all students
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    // Save or update a student
    @Override
    public Student save(Student theStudent) {
        // Use merge to save or update the student
        return entityManager.merge(theStudent);
    }

    // Find students who passed (average >= 70)
    @Override
    public List<Student> findPassStudents() {
        // Fetch all students and filter those with an average >= 70
        List<Student> allStudents = findAllStudents();
        return allStudents.stream()
                .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) >= 0)
                .collect(Collectors.toList());
    }

    // Delete student by ID
    @Override
    public void deleteStudentById(int id) {
        // Find the student by ID
        Student theStudent = entityManager.find(Student.class, id);
        if (theStudent != null) {
            // If found, remove the student
            entityManager.remove(theStudent);
        }
    }

    // Find students who failed (average < 70)
    @Override
    public List<Student> findFailStudents() {
        // Fetch all students and filter those with an average < 70
        List<Student> allStudents = findAllStudents();
        return allStudents.stream()
                .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) < 0)
                .collect(Collectors.toList());
    }

}
