package com.maurithiol.LoginSystem.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/dashboard/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/dashboard/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").authenticated()
                .antMatchers("/login", "/resources/**").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/auth/dashboard", true).permitAll()
                .and().logout().permitAll();
    }

}