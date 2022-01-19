package com.springboot.placenote.web.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.service.AuthService;
import com.springboot.placenote.service.CertifiedService;
import com.springboot.placenote.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthController {
	
    
	private final AuthService authService;
	private final CertifiedService certifiedService;
	
	@GetMapping("/auth/username-check")
	public boolean usernameCheck(@RequestParam String username) {
		return authService.usernameCheck(username);
	}
	
	@PostMapping("/auth/signup")
	public boolean signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
		return authService.insertAfterValidCheck(signupReqDto, bindingResult);
	}


	
	@GetMapping("/auth/sendSMS")
	public String sendSMS(String phoneNumber) {
		Random random = new Random();
		
		String numStr = "";
		for(int i = 0; i < 6; i++) {
			String ran = Integer.toString(random.nextInt(10));
			numStr += ran;
		}
		certifiedService.certifiedPhoneNumber(phoneNumber, numStr);
		return numStr;
	}
	
}
