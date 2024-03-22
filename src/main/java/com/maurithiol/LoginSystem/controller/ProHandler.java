package com.maurithiol.LoginSystem.controller;

import com.maurithiol.LoginSystem.auth.AuthUser;
import com.maurithiol.LoginSystem.auth.AuthUserRepository;
import com.maurithiol.LoginSystem.config.SecurityBeansConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProHandler {

    @Autowired
    private AuthUserRepository repository;
    private SecurityBeansConfig encoder = new SecurityBeansConfig();

    @RequestMapping("/auth/dashboard/admin/profile")
    public ModelAndView editAdminProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Optional<AuthUser> user = repository.findByUsername(username);
        ModelAndView mv = new ModelAndView("dashboard_admin_profile");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/auth/dashboard/admin/profile/add")
    public String addAdminProfile(AuthUser user) {
        if(user.getPassword() != null && user.getPassword().length() < 16) {
            user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        }
        repository.save(user);
        return "redirect:/auth/dashboard/admin/profile";
    }

    @RequestMapping("/auth/dashboard/user/profile")
    public ModelAndView editUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Optional<AuthUser> user = repository.findByUsername(username);
        ModelAndView mv = new ModelAndView("dashboard_user_profile");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping("/auth/dashboard/user/profile/add")
    public String addUserProfile(AuthUser user) {
        if(user.getPassword() != null && user.getPassword().length() < 16) {
            user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        }
        repository.save(user);
        return "redirect:/auth/dashboard/user/profile";
    }


}
