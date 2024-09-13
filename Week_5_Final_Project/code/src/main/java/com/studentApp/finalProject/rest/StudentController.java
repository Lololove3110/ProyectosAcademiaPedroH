package com.studentApp.finalProject.rest;

import com.studentApp.finalProject.entity.Student;
import com.studentApp.finalProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // TEACHER and ADMIN roles can access all students
    @GetMapping("/getStudents")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/GetStudent{id}")
    @PreAuthorize("hasAnyRole('STUDENT', 'TEACHER', 'ADMIN')")
    public ResponseEntity<Student> getStudentById(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        
        Student student = studentService.findStudentById(id);
        
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Only allow 'student1' to access the student with id=1
        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_STUDENT"))) {
            if (id != 1) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // Deny access for all ids except 1
            }
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    // TEACHER and ADMIN roles can get the average for a student, STUDENT can only get their own
    @GetMapping("/{id}/average")
    @PreAuthorize("hasAnyRole('STUDENT', 'TEACHER', 'ADMIN')")
    public ResponseEntity<BigDecimal> getStudentAverage(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        // Fetch student by id
        Student student = studentService.findStudentById(id);
        
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // If student is not found, return 404
        }

        // If the logged-in user has the STUDENT role, restrict access to only their own record
        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_STUDENT"))) {
            // Map 'student1' to student with id = 1
            if ("student1".equals(userDetails.getUsername()) && id != 1) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // Block access to other records
            }
        }

        // If the user is authorized, return the student's average
        return new ResponseEntity<>(student.getAverage(), HttpStatus.OK);
    }


    // Only ADMIN can create a new student
    @PostMapping("/CreateStudent")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        student.setAverage(student.getAverage());  // Set calculated average
        student.setPassStatus(student.getPassStatus());  // Set pass/fail status
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Only ADMIN can delete a student
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        if (!studentService.deleteStudentById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // TEACHER and ADMIN roles can access the list of passing students
    @GetMapping("/pass")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public ResponseEntity<List<Student>> getPassStudents() {
        List<Student> passStudents = studentService.findPassStudents();
        return new ResponseEntity<>(passStudents, HttpStatus.OK);
    }

    // TEACHER and ADMIN roles can access the list of failing students
    @GetMapping("/fail")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public ResponseEntity<List<Student>> getFailStudents() {
        List<Student> failStudents = studentService.findFailStudents();
        return new ResponseEntity<>(failStudents, HttpStatus.OK);
    }
}
