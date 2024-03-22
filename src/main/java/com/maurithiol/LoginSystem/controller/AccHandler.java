package com.maurithiol.LoginSystem.controller;

import com.maurithiol.LoginSystem.auth.AuthUser;
import com.maurithiol.LoginSystem.auth.AuthUserRepository;
import com.maurithiol.LoginSystem.config.SecurityBeansConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccHandler {

    @Autowired
    private AuthUserRepository repository;
    private SecurityBeansConfig encoder = new SecurityBeansConfig();

    @RequestMapping("/auth/dashboard/admin/accounts")
    public String userList(Model model) {
        List<AuthUser> users = repository.findAll();
        model.addAttribute("userList", users);
        return "dashboard_accounts";
    }

    @RequestMapping("/auth/dashboard/admin/accounts/new")
    public String showAddUserPage(Model model) {
        AuthUser user = new AuthUser();
        model.addAttribute("user", user);
        return "dashboard_new_account";
    }

    @PostMapping("/auth/dashboard/admin/accounts/add")
    public String addUser(AuthUser user) {
        if(user.getPassword().length() < 16 && user.getPassword() != null)
            user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        repository.save(user);
        return "redirect:/auth/dashboard/admin/accounts";
    }


    @RequestMapping("/auth/dashboard/admin/accounts/edit/{id}")
    public ModelAndView editUser(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("dashboard_edit_account");
        AuthUser user = repository.findById(id).orElse(null);
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping("/auth/dashboard/admin/accounts/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "redirect:/auth/dashboard/admin/accounts/";
    }

}