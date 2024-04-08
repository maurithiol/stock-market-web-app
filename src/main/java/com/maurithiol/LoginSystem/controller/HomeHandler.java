package com.maurithiol.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeHandler {

    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage";
    }
}
