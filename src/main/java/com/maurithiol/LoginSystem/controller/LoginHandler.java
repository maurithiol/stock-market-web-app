package com.maurithiol.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginHandler {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/auth/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

}