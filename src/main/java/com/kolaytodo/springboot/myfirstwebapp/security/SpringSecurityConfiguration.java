package com.kolaytodo.springboot.myfirstwebapp.security;


import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());

		http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.anyRequest().authenticated());
		http.formLogin(withDefaults());
		

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("resul", "1234");
		UserDetails userDetails2 = createNewUser("tenacious", "dummy");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);

	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoderFunc = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoderFunc).username(username)
				.password(password).roles("ADMIN", "USER").build();
		return userDetails;
	}

	// Spring security arkaplanda bu algoritmayı kullanmaktadır. By default
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
