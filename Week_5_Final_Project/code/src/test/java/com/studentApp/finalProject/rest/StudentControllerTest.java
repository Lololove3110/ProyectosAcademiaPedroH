package com.studentApp.finalProject.rest;

import com.studentApp.finalProject.entity.Student;
import com.studentApp.finalProject.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    // Mock test for retrieving all students - Admin or Teacher can access this.
    @Test
    @WithMockUser(roles = {"TEACHER"})
    public void testGetAllStudents() throws Exception {
        when(studentService.findAllStudents()).thenReturn(Arrays.asList(
                new Student("Smith", "John", new BigDecimal("10.00"), new BigDecimal("90.00")),    // Average = 50.0, Fail
                new Student("Johnson", "Emily", new BigDecimal("78.25"), new BigDecimal("82.50"))  // Average = 80.38, Pass
        ));

        mockMvc.perform(get("/api/students/getStudents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Smith"))
                .andExpect(jsonPath("$[0].average").value(50.00))
                .andExpect(jsonPath("$[0].passStatus").value("Fail"))
                .andExpect(jsonPath("$[1].firstName").value("Emily"))
                .andExpect(jsonPath("$[1].lastName").value("Johnson"))
                .andExpect(jsonPath("$[1].average").value(80.375))
                .andExpect(jsonPath("$[1].passStatus").value("Pass"));
    }

    // Mock test for retrieving passing students - Only Admin and Teacher can access this.
    @Test
    @WithMockUser(roles = {"TEACHER"})
    public void testGetPassStudents() throws Exception {
        when(studentService.findPassStudents()).thenReturn(Arrays.asList(
                new Student("Johnson", "Emily", new BigDecimal("78.25"), new BigDecimal("82.50"))  // Average = 80.38, Pass
        ));

        mockMvc.perform(get("/api/students/pass")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Emily"))
                .andExpect(jsonPath("$[0].lastName").value("Johnson"))
                .andExpect(jsonPath("$[0].average").value(80.375))
                .andExpect(jsonPath("$[0].passStatus").value("Pass"));
    }

    // Mock test for retrieving failing students - Only Admin and Teacher can access this.
    @Test
    @WithMockUser(roles = {"TEACHER"})
    public void testGetFailStudents() throws Exception {
        when(studentService.findFailStudents()).thenReturn(Arrays.asList(
                new Student("Smith", "John", new BigDecimal("10.00"), new BigDecimal("90.00"))  // Average = 50.0, Fail
        ));

        mockMvc.perform(get("/api/students/fail")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Smith"))
                .andExpect(jsonPath("$[0].average").value(50.00))
                .andExpect(jsonPath("$[0].passStatus").value("Fail"));
    }

    // Mock test for retrieving a student by ID - Student, Teacher, or Admin can access this.
    @Test
    @WithMockUser(roles = {"STUDENT"})
    public void testGetStudentById() throws Exception {
        Student student = new Student("Smith", "John", new BigDecimal("10.00"), new BigDecimal("90.00")); // Average = 50.0, Fail
        when(studentService.findStudentById(1)).thenReturn(student);

        mockMvc.perform(get("/api/students/GetStudent1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Smith"))
                .andExpect(jsonPath("$.average").value(50.00))
                .andExpect(jsonPath("$.passStatus").value("Fail"));
    }

    // Test for a non-existent student
    @Test
    @WithMockUser(roles = {"STUDENT"})
    public void testGetStudentByIdNotFound() throws Exception {
        when(studentService.findStudentById(1)).thenReturn(null);

        mockMvc.perform(get("/api/students/GetStudent1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // Mock test for creating a student - Only Admin can access this.
//   @Test
//   @WithMockUser(roles = {"ADMIN"})  // Simulates a user with the ADMIN role
//    public void testCreateStudent() throws Exception {
//        mockMvc.perform(post("/api/students/CreateStudent")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{ \"firstName\": \"Jane\", \"lastName\": \"Doe\", \"firstPeriod\": 60.00, \"secondPeriod\": 65.00 }"))
//                .andExpect(status().isCreated());  // 
//    }

    // Mock test for deleting a student - Only Admin can delete a student.
//    @Test
//    @WithMockUser(roles = {"ADMIN"})
//    public void testDeleteStudent() throws Exception {
//        when(studentService.deleteStudentById(1)).thenReturn(true);
//
//        mockMvc.perform(delete("/api/students/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//
//        verify(studentService, times(1)).deleteStudentById(1);
//    }
//
//    // Test for trying to delete a non-existent student
//    @Test
//    @WithMockUser(roles = {"ADMIN"})
//    public void testDeleteStudentNotFound() throws Exception {
//        when(studentService.deleteStudentById(1)).thenReturn(false);
//
//        mockMvc.perform(delete("/api/students/75")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }

    // Mock test for getting a student's average - Students, Teachers, and Admins can access.
    @Test
    @WithMockUser(roles = {"STUDENT"})
    public void testGetStudentAverage() throws Exception {
        Student student = new Student("Smith", "John", new BigDecimal("10.00"), new BigDecimal("90.00")); // Average = 50.0, Fail
        when(studentService.findStudentById(1)).thenReturn(student);

        mockMvc.perform(get("/api/students/1/average")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("50.00"));
    }

    // Test for trying to get an average for a non-existent student
    @Test
    @WithMockUser(roles = {"STUDENT"})
    public void testGetStudentAverageNotFound() throws Exception {
        when(studentService.findStudentById(1)).thenReturn(null);

        mockMvc.perform(get("/api/students/1/average")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()); 
    }
}
