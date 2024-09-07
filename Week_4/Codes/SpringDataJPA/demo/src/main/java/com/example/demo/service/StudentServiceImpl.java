package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student save(Student theStudent) {
		return studentRepository.save(theStudent);
	}
	
	@Override
    public List<Student> findPassStudents() {
        return studentRepository.findAll().stream()
            .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) >= 0)
            .collect(Collectors.toList());
    }
	
	@Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
	
	@Override
	public List<Student> findFailStudents() {
        return studentRepository.findAll().stream()
            .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) < 0)
            .collect(Collectors.toList());
    }
	
	
	
	

}
