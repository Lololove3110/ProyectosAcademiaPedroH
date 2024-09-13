package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// Define field for EntityManager
    private final EntityManager entityManager;

    // Inject EntityManager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        System.out.println("Saving student: " + theStudent);
        entityManager.persist(theStudent); // JPA
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // JPA
    }

    @Override
    public List<Student> findAll() {
        // Create query to retrieve all students
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList(); // JPA
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query to find students by last name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theLastName", Student.class);
        theQuery.setParameter("theLastName", lastName);
        return theQuery.getResultList(); // JPA
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        System.out.println("Updating student: " + theStudent);
        entityManager.merge(theStudent); // JPA
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // Retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
        if (theStudent != null) {
            System.out.println("Deleting student: " + theStudent);
            entityManager.remove(theStudent); // JPA
        }
    }

    @Override
    @Transactional
    public int deleteAll() {
        // Delete all students and return the number of rows deleted
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate(); // JPA
        return numRowsDeleted;
    }
}










