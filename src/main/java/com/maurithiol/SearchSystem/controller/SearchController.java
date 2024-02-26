package com.maurithiol.SearchSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @PostMapping("/homepage")
    public String search(@RequestParam("search") String searchTerm, Model model) {
        String searchResult = "Vous avez recherché : " + searchTerm;
        model.addAttribute("searchResult", searchResult);
        return "homepage";
    }
}