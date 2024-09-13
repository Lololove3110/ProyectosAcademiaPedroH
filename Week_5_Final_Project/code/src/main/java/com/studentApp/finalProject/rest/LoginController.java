package com.studentApp.finalProject.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "fancy-login";  // This points to the Thymeleaf login template (fancy-login.html)
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";  // This points to the Thymeleaf access denied template (access-denied.html)
    }
}
