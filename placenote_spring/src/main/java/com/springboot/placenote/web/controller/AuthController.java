package com.springboot.placenote.web.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.service.AuthService;
import com.springboot.placenote.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthController {
	
	private final AuthService authService;
	
	@GetMapping("/auth/username-check")
	public boolean usernameCheck(@RequestParam String username) {
		return authService.usernameCheck(username);
	}
	
	@PostMapping("/auth/signup")
	public boolean signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
		return authService.insertAfterValidCheck(signupReqDto, bindingResult);
	}
	
}
