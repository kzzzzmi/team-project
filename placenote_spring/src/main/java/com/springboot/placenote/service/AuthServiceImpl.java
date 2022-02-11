package com.springboot.placenote.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;
import com.springboot.placenote.domain.user.UserRepository;
import com.springboot.placenote.web.dto.auth.MyInfoReqDto;
import com.springboot.placenote.web.dto.auth.PasswordReqDto;
import com.springboot.placenote.web.dto.auth.PasswordRespDto;
import com.springboot.placenote.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    
    	
    	@Autowired
	private final UserRepository userRepository;
	
    	@Value("${file.path}")
    	private String filePath;
    	
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

	@Override
	public int getUserId(String username) {
	    User userEntity = userRepository.getUserByUsername(username);
	    return userEntity.getId();
	}

	
	
	 public void deleteProfileImgFile(PrincipalDetails principalDetails) { 
	  String imgUrl = principalDetails.getUserDtl().getProfile_img();
	  System.out.println(imgUrl);
	  if(!imgUrl.equals("profile_img/mona-loading-default.gif")) { 
	  File file = new File(filePath + imgUrl); 
	  if(file.exists()) {
	   file.delete(); 
	  	}
	  }
	 }
	 

	@Override
	public boolean updateuser(PrincipalDetails principalDetails, MyInfoReqDto myInfoReqDto) {
	    
	    int id = principalDetails.getUser().getId();
	    String password = principalDetails.getUser().getPassword();
	    String profile_img = null;
	    
	    User userEntity = myInfoReqDto.toUserEntity(id , password);
	    UserDtl userDtlEntity = null;
	    
	    int result = 0;
	    System.out.println(myInfoReqDto);
	    if(myInfoReqDto.getFile() == null) {
		
		profile_img = principalDetails.getUserDtl().getProfile_img();
	
	    }else {
		String imgFilename = UUID.randomUUID().toString().replaceAll("-", "") + myInfoReqDto.getFile().getOriginalFilename();
		Path imgFilePath = Paths.get(filePath, "profile_img/" + imgFilename);
		
		File file = new File(filePath + "profile_img");
		if(!file.exists()) {
		    file.mkdirs();
		}
		
		try {
		    Files.write(imgFilePath, myInfoReqDto.getFile().getBytes());
		} catch (IOException e) {
		    
		    e.printStackTrace();
		}
		profile_img = "profile_img/" + imgFilename;
		
		deleteProfileImgFile(principalDetails);
	    }
	    
	    userDtlEntity = myInfoReqDto.toUserDtlEntity(id, profile_img);
		
	    result += userRepository.updateUserDtlById(userDtlEntity);
	    result += userRepository.updateUserById(userEntity);
		
		
	    if(result == 2) {
		    
		    principalDetails.setUser(userEntity);;
		    principalDetails.setUserDtl(userDtlEntity);
		    
		    return true;
		}else {
		    
		    return false;
		}
	}
	
	//비밀번호 변경 암호화 / 중복체크
	public boolean PasswordCheck(String principalPassword , String Password) {
	    
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    
	    System.out.println("principalPassword :" + principalPassword);
	    System.out.println("password :" + Password);
	    
	    return encoder.matches(Password , principalPassword); // 매개변수 순서 암호화 되지 않은 값 , 기존의 암호화된 패스워드
	    
	}
	
	@Override
	public PasswordRespDto updatePassword(PrincipalDetails principalDetails, PasswordReqDto passwordReqDto) {
	    
	    boolean prepasswordCheckFlag = PasswordCheck(principalDetails.getPassword() , passwordReqDto.getPrePassword());
	    boolean newpasswordCheckFlag = PasswordCheck(principalDetails.getPassword() , passwordReqDto.getNewPassword());
	    
	    PasswordRespDto passwordRespDto = new PasswordRespDto();
	    
	    if(prepasswordCheckFlag == false) {
		//현재 비밀번호가 일치하지 않음
		
		passwordRespDto.setCode(450);
		passwordRespDto.setMessage("현재 비밀번호가 일치하지 않습니다");
		
	    }else if(newpasswordCheckFlag == true) {
		//현재 비밀번호와 새 비밀번호가 일치할때
		
		passwordRespDto.setCode(400);
		passwordRespDto.setMessage("현재 비밀번호와 일치합니다.다시 입력해주세요");
		
	    }else{
		//새 비밀번호로 변경
		User userEntity = passwordReqDto.toEntity(principalDetails.getUser().getId());
		int reslut = userRepository.updatePasswordById(userEntity);
		
		if(reslut == 1) {
		    passwordRespDto.setCode(200);
		    passwordRespDto.setMessage("비밀번호가 변경되었습니다.");
		    principalDetails.getUser().setPassword(userEntity.getPassword());
		}
	    }
	    
	    return passwordRespDto;
	}
}
