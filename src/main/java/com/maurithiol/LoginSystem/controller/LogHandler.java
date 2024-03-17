package com.maurithiol.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.maurithiol.LoginSystem.auth.AuthRole;
import com.maurithiol.LoginSystem.auth.AuthUser;
import com.maurithiol.LoginSystem.auth.AuthUserRepository;
import com.maurithiol.LoginSystem.config.SecurityBeansConfig;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LogHandler {

    private final AuthUserRepository repository;
    private final SecurityBeansConfig encoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") AuthUser user) {
        if (repository.existsByUsername(user.getUsername()))
            return "redirect:/register";
        AuthUser curr = new AuthUser();
        curr.setUsername(user.getUsername());
        curr.setEmail(user.getEmail());
        curr.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        curr.setRole(AuthRole.USER);
        curr.setActive(true);
        repository.save(curr);
        return "redirect:/login";
    }

    @GetMapping("/auth/dashboard/user")
    public String showUserDashboard() {
        return "dashboard_user";
    }

    @GetMapping("/auth/dashboard/admin")
    public String showAdminDashboard() {
        return "dashboard_admin";
    }

}