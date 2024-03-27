package com.maurithiol.LoginSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.maurithiol.LoginSystem.SearchBar.DataList;

@Controller
public class HomeHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage";
    }

    @PostMapping("/homepage")
    public String search(@RequestParam("search") String searchTerm, Model model) throws Exception {
        String apiRequest = "https://api.twelvedata.com/symbol_search?symbol=";
        apiRequest += searchTerm;
        DataList dataList = restTemplate.getForObject(apiRequest, DataList.class);
        model.addAttribute("dataList", dataList.getData());
        return "homepage";
    }
}
