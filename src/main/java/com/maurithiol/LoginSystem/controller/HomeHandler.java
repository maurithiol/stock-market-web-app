package com.maurithiol.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeHandler {
    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage";
    }

    @PostMapping("/homepage")
    public String search(@RequestParam("search") String searchTerm, Model model) throws Exception {
        return "homepage";
    }
}
