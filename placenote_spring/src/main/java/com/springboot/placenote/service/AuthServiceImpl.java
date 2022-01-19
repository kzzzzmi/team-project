package com.springboot.placenote.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserRepository;
import com.springboot.placenote.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    
    	@Autowired
	private final UserRepository userRepository;
	
	public boolean usernameCheck(String username) {
		int result = userRepository.checkUsernameByUsername(username);
		if(result == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean insertAfterValidCheck(SignupReqDto signupReqDto, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			int checkUsernameResult = userRepository.checkUsernameByUsername(signupReqDto.getUsername());
			if(checkUsernameResult == 0) {
				User user = signupReqDto.toUserEntity();
				user.setRole("ROLE_USER");
				userRepository.insertUser(user);
				return true;
			} 
		}
		return false;
	}

	


}
