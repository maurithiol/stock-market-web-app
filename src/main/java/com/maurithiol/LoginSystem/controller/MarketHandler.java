package com.maurithiol.LoginSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MarketHandler {

    @GetMapping("/auth/dashboard/user/market")
    public String showUserMarket() {
        return "dashboard_user_market";
    }

    @GetMapping("/auth/dashboard/admin/market")
    public String showAdminMarket() {
        return "dashboard_admin_market";
    }

}