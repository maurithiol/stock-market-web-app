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
			AuthUser user = new AuthUser();
			user.setUsername("admin");
			user.setEmail("maurithiol@gmail.com");
			user.setPassword(new BCryptPasswordEncoder().encode("1234"));
			user.setRole(AuthRole.ADMIN);
			user.setActive(true);
			repository.save(user);
		};
	}*/

}