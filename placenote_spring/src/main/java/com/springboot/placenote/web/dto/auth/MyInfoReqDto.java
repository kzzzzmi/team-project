package com.springboot.placenote.web.dto.auth;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;

import lombok.Data;

@Data
public class MyInfoReqDto {
    
    private String username;
    private String email;
    private String phone;
    
    private MultipartFile file;
    
    public User toUserEntity(int id , String password) {
	return User.builder()
			.id(id)
			.username(username)
			.password(password)
			.email(email)
			.phone(phone)
			.build();
    }
    public UserDtl toUserDtlEntity(int id , String profile_img) {
	return UserDtl.builder()
			.id(id)
			.profile_img(profile_img)
			.build();
    }
}
