package com.maurithiol.LoginSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class NewsHandler {

    @GetMapping("/auth/dashboard/user/news")
    public String showUserMarket() {
        return "dashboard_user_news";
    }

    @GetMapping("/auth/dashboard/admin/news")
    public String showAdminMarket() {
        return "dashboard_admin_news";
    }

}
