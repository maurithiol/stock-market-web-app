package com.maurithiol.LoginSystem.auth;

import com.maurithiol.LoginSystem.config.SecurityBeansConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthUserRepository userRepository;
    private final SecurityBeansConfig beans;

    @Autowired
    public AuthUserDetailsService(AuthUserRepository userRepository, SecurityBeansConfig beans) {
        this.userRepository = userRepository;
        this.beans = beans;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = userRepository.findByUsername(username.toLowerCase());
        if (!authUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {
            return new AuthUserDetails(
                    authUser.get().getUsername(),
                    authUser.get().getEmail(),
                    authUser.get().getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(authUser.get().getRole().name()))
            );
        }
    }

}
