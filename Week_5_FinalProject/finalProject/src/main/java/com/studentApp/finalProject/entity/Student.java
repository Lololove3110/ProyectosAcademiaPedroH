package com.studentApp.finalProject.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;



@Data
@AllArgsConstructor
@Entity
@Table(name="Students")
public class Student {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name", length = 64)
    private String lastName;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "first_period", precision = 10, scale = 2)
    private BigDecimal firstPeriod;

    @Column(name = "second_period", precision = 10, scale = 2)
    private BigDecimal secondPeriod;
    
    // This field is not stored directly in the database, but calculated in the getter.
    @Transient
    private BigDecimal average;

    // This field is also calculated based on the average.
    @Transient
    private String passStatus;

 // // Constructors, getters, and setters

    public Student() {}

    public Student(String lastName, String firstName, BigDecimal firstPeriod, BigDecimal secondPeriod) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.firstPeriod = firstPeriod;
        this.secondPeriod = secondPeriod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(BigDecimal firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public BigDecimal getSecondPeriod() {
        return secondPeriod;
    }

    public void setSecondPeriod(BigDecimal secondPeriod) {
        this.secondPeriod = secondPeriod;
    }

    // The average is computed based on first_period and second_period
   
    
    public BigDecimal getAverage() {
        if (firstPeriod != null && secondPeriod != null) {
            return firstPeriod.add(secondPeriod).divide(new BigDecimal(2));
        }
        return BigDecimal.ZERO;
    }
    
    

    // Pass status is determined based on the average
    public String getPassStatus() {
        BigDecimal avg = getAverage();
        if (avg.compareTo(new BigDecimal(70)) >= 0) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
    
    
    
}