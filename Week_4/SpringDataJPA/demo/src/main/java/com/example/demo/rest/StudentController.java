package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/rest")
public class StudentController {
	
	StudentService studentservice;
	
	@Autowired
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}

	
	
	@GetMapping("/Student")
	public List<Student> findAllStudents() {
		return studentservice.findAllStudents();
	}
	
	@PostMapping("/Student")
	public Student addStudent(@RequestBody Student theStudent) {
		theStudent.setId(0);
		
		Student dbStudent = studentservice.save(theStudent);
		return dbStudent;
		
	} 
	
	@GetMapping("/Students/pass")
    public List<Student> getPassStudents() {
        return studentservice.findPassStudents();
    }
	
	@DeleteMapping("/Student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentservice.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
	
	@GetMapping("Students/fail")
	public List<Student> getFailStudent(){
		return studentservice.findFailStudents();
	}


}
