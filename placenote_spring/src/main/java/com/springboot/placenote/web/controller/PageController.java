package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.placenote.config.auth.PrincipalDetails;

@Controller
public class PageController {
	
	@GetMapping({"/", "/index"})
	public String indexPage(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		return "index";
	}
	
	@GetMapping("/auth/signin")
	public String signinPage() {
		return "/auth/signin";
	}
	
}
