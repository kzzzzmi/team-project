package com.springboot.placenote.web.dto.auth;



import com.springboot.placenote.domain.user.User;

import lombok.Data;

@Data
public class SigninReqDto {

    private String username;
    private String password;
    
    public User toEntity() {
	return User.builder()
		.username(username)
		.password(password)
		.build();
    }
 
    
}
