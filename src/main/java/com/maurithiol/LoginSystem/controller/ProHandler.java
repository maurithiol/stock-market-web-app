package com.maurithiol.LoginSystem.controller;

import com.maurithiol.LoginSystem.auth.AuthUser;
import com.maurithiol.LoginSystem.auth.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProHandler {

    @Autowired
    private AuthUserRepository repository;

    @RequestMapping("/auth/dashboard/admin/profile")
    public ModelAndView updateAdminProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Optional<AuthUser> user = repository.findByUsername(username);
        ModelAndView mv = new ModelAndView("dashboard_admin_profile");
        mv.addObject("profile", user);
        return mv;
    }

    @RequestMapping("/auth/dashboard/user/profile")
    public ModelAndView updateUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Optional<AuthUser> user = repository.findByUsername(username);
        ModelAndView mv = new ModelAndView("dashboard_user_profile");
        mv.addObject("profile", user);
        return mv;
    }

}
