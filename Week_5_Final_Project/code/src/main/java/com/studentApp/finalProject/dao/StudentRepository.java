package com.studentApp.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.studentApp.finalProject.entity.*;

public interface StudentRepository extends JpaRepository<Student,Integer>{



}
