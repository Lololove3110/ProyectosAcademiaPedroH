package com.studentApp.finalProject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentApp.finalProject.entity.Student;
import com.studentApp.finalProject.dao.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student theStudent) {
        return studentRepository.save(theStudent);
    }

    

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findPassStudents() {
        return studentRepository.findAll().stream()
            .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) >= 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<Student> findFailStudents() {
        return studentRepository.findAll().stream()
            .filter(student -> student.getAverage().compareTo(new BigDecimal(70)) < 0)
            .collect(Collectors.toList());
    }

}
