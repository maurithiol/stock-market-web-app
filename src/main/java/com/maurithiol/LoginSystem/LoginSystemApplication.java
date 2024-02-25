package com.maurithiol.LoginSystem;

import com.maurithiol.LoginSystem.auth.AuthRole;
import com.maurithiol.LoginSystem.auth.AuthUser;
import com.maurithiol.LoginSystem.auth.AuthUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSystemApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner runner(AuthUserRepository repository) {
		return args -> {
			AuthUser authUser = new AuthUser("0", "admin", new BCryptPasswordEncoder().encode("1234"), AuthRole.ADMIN,true);
			repository.insert(authUser);
		};
	}*/

}