package com.maurithiol.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.maurithiol.APICall.data.DataList;
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

    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage";
    }

    @PostMapping("/homepage")
    public String search(@RequestParam("search") String searchTerm, Model model) throws Exception {
        String apiRequest = "https://api.twelvedata.com/symbol_search?symbol=";
        apiRequest += searchTerm;
        RestTemplate restTemplate = new RestTemplate();
        DataList dataList = restTemplate.getForObject(apiRequest, DataList.class);
        model.addAttribute("dataList", dataList.getData());
        return "homepage";
    }

}