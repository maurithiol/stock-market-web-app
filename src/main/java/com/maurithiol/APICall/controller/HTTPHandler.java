package com.maurithiol.APICall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HTTPHandler {


    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage";
    }

    @GetMapping("/homepage/stock/{symbol}")
    public String showStockData() {
        return "stock";
    }

}