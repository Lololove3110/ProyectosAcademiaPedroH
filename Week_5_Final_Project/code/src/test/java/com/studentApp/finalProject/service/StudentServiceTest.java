package com.studentApp.finalProject.service;

import com.studentApp.finalProject.dao.StudentRepository;
import com.studentApp.finalProject.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentDao;

    private Student passingStudent;
    private Student failingStudent;

    @BeforeEach
    void setUp() {
        // Initialize Mockito for the test class
        MockitoAnnotations.openMocks(this);

        // Create mock student data with BigDecimal values for precision
        passingStudent = new Student("Emily", "Johnson", new BigDecimal("78.25"), new BigDecimal("82.50"));  // Average = 80.38, Pass
        failingStudent = new Student("John", "Smith", new BigDecimal("10.00"), new BigDecimal("90.00"));     // Average = 50.0, Fail
    }

    @Test
    void findPassStudents() {
        // Mock the call to findAll() to return both passing and failing students
        when(studentDao.findAll()).thenReturn(Arrays.asList(passingStudent, failingStudent));

        // Get the passing students
        List<Student> passStudents = studentService.findPassStudents();

        // Verify that only the passing student is returned
        assertEquals(1, passStudents.size());
        assertEquals(passingStudent, passStudents.get(0));
    }

    @Test
    void findFailStudents() {
        // Mock the call to findAll() to return both passing and failing students
        when(studentDao.findAll()).thenReturn(Arrays.asList(passingStudent, failingStudent));

        // Get the failing students
        List<Student> failStudents = studentService.findFailStudents();

        // Verify that only the failing student is returned
        assertEquals(1, failStudents.size());
        assertEquals(failingStudent, failStudents.get(0));
    }

    @Test
    void testGetAverageForStudent() {
        // Test average calculation directly from the student entity
        assertEquals(new BigDecimal("80.375"), passingStudent.getAverage());
        assertEquals(new BigDecimal("50.00"), failingStudent.getAverage());
    }

    @Test
    void testFindStudentById() {
        // Mock the behavior of finding a student by ID
        when(studentDao.findById(1)).thenReturn(Optional.of(passingStudent));

        Student result = studentService.findStudentById(1);

        assertNotNull(result);
        assertEquals(passingStudent, result);
    }

    @Test
    void testSaveStudent() {
        // Mock the save method
        studentService.saveStudent(passingStudent);
        verify(studentDao, times(1)).save(passingStudent);
    }

    @Test
    void testDeleteStudentById() {
        // Mock student existence and deletion
        when(studentDao.existsById(1)).thenReturn(true);

        boolean result = studentService.deleteStudentById(1);
        assertTrue(result);
        verify(studentDao, times(1)).deleteById(1);
    }

    @Test
    void testDeleteStudentByIdNotFound() {
        // Mock student non-existence
        when(studentDao.existsById(1)).thenReturn(false);

        boolean result = studentService.deleteStudentById(1);
        assertFalse(result);
    }
}
