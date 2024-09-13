package com.studentApp.finalProject.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Refers to the home.html Thymeleaf template
    }
}
