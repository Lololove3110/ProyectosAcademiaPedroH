package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
@Entity
@Table(name="Students")
public class Student {

    // Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="first_period")
    private double firstPeriod;

    @Column(name="second_period")
    private double secondPeriod;

    // Define constructors
    public Student() {
        // No-arg constructor
    }

    public Student(String lastName, String firstName, double firstPeriod, double secondPeriod) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.firstPeriod = firstPeriod;
        this.secondPeriod = secondPeriod;
    }

    // Define getters/setters
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

    public double getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(double firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public double getSecondPeriod() {
        return secondPeriod;
    }

    public void setSecondPeriod(double secondPeriod) {
        this.secondPeriod = secondPeriod;
    }

    // Define toString() method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", firstPeriod=" + firstPeriod +
                ", secondPeriod=" + secondPeriod +
                '}';
    }
    
}