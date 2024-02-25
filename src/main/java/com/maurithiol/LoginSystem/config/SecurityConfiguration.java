package com.maurithiol.LoginSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

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