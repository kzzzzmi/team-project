package com.springboot.placenote.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.user.User;

@Controller
public class ProfileController {
    
    @GetMapping("/username")
    public User authUserName(PrincipalDetails principalDetails) {
	return principalDetails.getUser();
    }
    
}
