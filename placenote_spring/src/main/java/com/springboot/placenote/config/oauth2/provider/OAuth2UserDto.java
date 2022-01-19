package com.springboot.placenote.config.oauth2.provider;


import com.springboot.placenote.domain.user.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OAuth2UserDto {

    private String oauth2_username;
    private String email;
    private String name;
    private String provider;
    private String role;
    private String gender;
    private String phone;
    
    public User toEntity() {
	return User.builder()
		.username(oauth2_username)
		.oauth2_username(oauth2_username)
		.email(email)
		.name(name)
		.provider(provider)
		.role(role)
		.phone(phone)
		.gender(gender)
		.build();
    }
}
