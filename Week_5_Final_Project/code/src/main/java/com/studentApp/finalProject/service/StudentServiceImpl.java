package com.studentApp.finalProject.service;

import com.studentApp.finalProject.dao.StudentRepository;
import com.studentApp.finalProject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentDao;

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.findById(id).orElse(null);
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.save(student);
    }
    
    

    @Override
    public boolean deleteStudentById(int id) {
        if (studentDao.existsById(id)) {
            studentDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findPassStudents() {
        return studentDao.findAll().stream()
                .filter(student -> "Pass".equals(student.getPassStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findFailStudents() {
        return studentDao.findAll().stream()
                .filter(student -> "Fail".equals(student.getPassStatus()))
                .collect(Collectors.toList());
    }
}
