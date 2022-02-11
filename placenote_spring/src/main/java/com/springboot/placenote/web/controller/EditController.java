package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.service.AuthService;
import com.springboot.placenote.web.dto.auth.MyInfoReqDto;
import com.springboot.placenote.web.dto.auth.PasswordReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EditController {

    private final AuthService authService;
    
    @PatchMapping("/myInfo/edit")
    public boolean profileEdit(@AuthenticationPrincipal PrincipalDetails principalDetails , MyInfoReqDto myInfoReqDto) {
	
	return authService.updateuser(principalDetails, myInfoReqDto);
    } 
    @PutMapping("/password/change")
    public Object passwordChange(@AuthenticationPrincipal PrincipalDetails principalDetails , PasswordReqDto passwordReqDto) {
	System.out.println(passwordReqDto);
	return authService.updatePassword(principalDetails, passwordReqDto);
	
    }
 }
	 
