package com.luv2code.springboot.JpaCrud.entity;



import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Students")


public class Student {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "first_period")
    private BigDecimal firstPeriod;

    @Column(name = "second_period")
    private BigDecimal secondPeriod;

    // Add the following two fields to match the generated fields in MySQL
    @Column(name = "average", insertable = false, updatable = false)  // Computed in DB, read-only in Java
    private BigDecimal average;

    @Column(name = "pass_status", insertable = false, updatable = false)  // Computed in DB, read-only in Java
    private String passStatus;

    // Getters and setters

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

    public BigDecimal getAverage() {
        return average;
    }

    public String getPassStatus() {
        return passStatus;
    }

}
