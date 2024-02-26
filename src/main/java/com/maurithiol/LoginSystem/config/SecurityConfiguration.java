package com.maurithiol.LoginSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/register", "/resources/**").permitAll()
                //.antMatchers("/auth/dashboard/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/dashboard/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/auth/dashboard", true).permitAll()
                .and().logout().permitAll();
    }

}