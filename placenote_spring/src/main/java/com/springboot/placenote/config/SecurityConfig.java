package com.springboot.placenote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.config.oauth2.PrincipalOAuth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    	private final PrincipalOAuth2UserService principalOAuth2UserService; 
    
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
		.antMatchers()
		.authenticated()
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()	
		.usernameParameter("username")
		.passwordParameter("password")
		.loginPage("/auth/signin")
		.loginProcessingUrl("/auth/signin")
		.defaultSuccessUrl("/")
		.and()
		.oauth2Login()
		.loginPage("/auth/signin")
		.userInfoEndpoint()
		.userService(principalOAuth2UserService)
		.and()
		.defaultSuccessUrl("/");
	}
}
