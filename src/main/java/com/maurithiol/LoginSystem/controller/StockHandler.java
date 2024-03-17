package com.maurithiol.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockHandler {
    @GetMapping("/test")
    public String showDefaultTestPage() {
        return "test";
    }

    @GetMapping("/test/{stockName}")
    public String showTestPage() {
        return "test";
    }

    @GetMapping("/stock")
    public String showDefaultStockPage() {
        return "stock";
    }

    @GetMapping("/stock/{stockName}")
    public String showStockPage() {
        return "stock";
    }
}
