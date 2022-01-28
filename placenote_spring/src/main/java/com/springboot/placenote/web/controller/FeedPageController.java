package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.service.ProfileService;
import com.springboot.placenote.web.dto.auth.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/feed")
public class FeedPageController {
    
    
    private final ProfileService profileService;
    
    @GetMapping("/{username}/image")
    public String OtherfeedImgPage(Model model,@PathVariable String username , @AuthenticationPrincipal PrincipalDetails principalDetails ) {
	ProfileRespDto profileRespDto = new ProfileRespDto();
	if (principalDetails != null && principalDetails.getUser().getUsername().equals(username)) {
	    profileRespDto.setProfile_img(principalDetails.getUserDtl().getProfile_img());
	    profileRespDto.setUsername(username);
	    profileRespDto.setUserid(principalDetails.getUserDtl().getId());
	    
	    model.addAttribute("profileRespDto", profileRespDto);
	    return "/feed/my_feedImg";
	
	
	   
	} else {
	    
	    
	  
	    profileRespDto = profileService.getProfile(principalDetails , username); 
	    model.addAttribute("profileRespDto", profileRespDto);
	    return "/feed/other_feedImg";
	}
    

    }
    
    
    }

