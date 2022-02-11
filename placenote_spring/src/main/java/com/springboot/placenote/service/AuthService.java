package com.springboot.placenote.service;


import org.springframework.validation.BindingResult;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.web.dto.auth.MyInfoReqDto;
import com.springboot.placenote.web.dto.auth.PasswordReqDto;
import com.springboot.placenote.web.dto.auth.PasswordRespDto;
import com.springboot.placenote.web.dto.auth.ProfileRespDto;
import com.springboot.placenote.web.dto.auth.SignupReqDto;

public interface AuthService {
	
    	
	public boolean usernameCheck(String username);
	public boolean insertAfterValidCheck(SignupReqDto signupReqDto, BindingResult bindingResult);
	public int getUserId(String username);
	
	//프로필 편집
	public boolean updateuser(PrincipalDetails principalDetails , MyInfoReqDto myInfoReqDto);
	//비밀번호 수정검사
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails , PasswordReqDto passwordReqDto);
	
}
