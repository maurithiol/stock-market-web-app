package com.maurithiol.LoginSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/register", "/resources/**").permitAll()
                .antMatchers("/auth/dashboard/admin/**").hasAuthority("ADMIN")
                .antMatchers("/auth/dashboard/user/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/auth/dashboard/user")
                .successHandler((request, response, authentication) -> {
                    for (GrantedAuthority authority : authentication.getAuthorities()) {
                        if (authority.getAuthority().equals("ADMIN")) {
                            response.sendRedirect("/auth/dashboard/admin");
                            return;
                        }
                    }
                    response.sendRedirect("/auth/dashboard/user");
                })
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}