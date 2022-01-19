package com.springboot.placenote.web.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;

import lombok.Data;

@Data
public class SignupReqDto {
	@NotBlank
	private String username;
	@NotBlank
	@Size(max = 20)
	private String password;
	@NotBlank
	private String name;
	@NotBlank
	private String gender;
	@NotBlank
	private String email;
	@NotBlank
	private String phone;
	
	public User toUserEntity() {
		return User.builder()
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password))
				.name(name)
				.gender(gender)
				.email(email)
				.phone(phone)
				.build();
	}
}
