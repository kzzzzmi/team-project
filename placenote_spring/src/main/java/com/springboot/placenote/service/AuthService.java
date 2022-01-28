package com.springboot.placenote.service;


import org.springframework.validation.BindingResult;

import com.springboot.placenote.web.dto.auth.SignupReqDto;

public interface AuthService {
	
    	
	public boolean usernameCheck(String username);
	public boolean insertAfterValidCheck(SignupReqDto signupReqDto, BindingResult bindingResult);
	public int getUserId(String username);
	
	
}
