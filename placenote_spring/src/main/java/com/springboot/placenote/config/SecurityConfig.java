package com.springboot.placenote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		http.authorizeRequests()//서버에 요청이 들어오면
		.antMatchers("/upload" , "/myInfo")// 해당요청들은
		.authenticated()//모두 인증을 거처야한다.
		.anyRequest()//그외의 모든 요청은 
		.permitAll()//승인해준다.(모두 권한을 허가)
		.and()//그리고
		.formLogin()//로그인 화면은	
		.usernameParameter("username")
		.passwordParameter("password")
		.loginPage("/auth/signin")//해당 GET 요청으로 응답해주면 되고
		.loginProcessingUrl("/auth/signin")//로그인 submit요청시에 POST 요청으로 /auth/signin 요청을 해라
		.defaultSuccessUrl("/")//로그인에 성공했으면 해당 URL 로 이동을 해라
		.and()
		.oauth2Login()
		.loginPage("/auth/signin")
		.userInfoEndpoint()
		.userService(principalOAuth2UserService)
		.and()
		.defaultSuccessUrl("/");
	}
}
