package com.springboot.placenote.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Bean public BCryptPasswordEncoder encoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/", "/index").authenticated().anyRequest().permitAll().and().formLogin()
				.usernameParameter("username").passwordParameter("password").loginPage("/auth/signin")
				.loginProcessingUrl("/auth/signin").defaultSuccessUrl("/");
	}
}
