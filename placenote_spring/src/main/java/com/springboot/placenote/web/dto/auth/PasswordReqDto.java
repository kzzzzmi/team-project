package com.springboot.placenote.web.dto.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.placenote.domain.user.User;

import lombok.Data;

@Data
public class PasswordReqDto {
    
    private String prePassword;
    private String newPassword;
    
    public User toEntity(int id) {
	return User.builder()
			.id(id)
			.password(new BCryptPasswordEncoder().encode(newPassword))
			.build();
    }
}
