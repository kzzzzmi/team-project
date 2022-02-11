package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.follow.FollowRepository;
import com.springboot.placenote.service.AuthService;
import com.springboot.placenote.service.ProfileService;
import com.springboot.placenote.web.dto.auth.MyInfoReqDto;
import com.springboot.placenote.web.dto.auth.PasswordReqDto;
import com.springboot.placenote.web.dto.auth.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PageController {

	private final ProfileService profileService;

	
	@GetMapping("/index")
	public String indexPage(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		return "index";
	}

	@GetMapping("/auth/signin")
	public String signinPage() {
		return "/auth/signin";
	}

	@GetMapping("/auth/signup")
	public String signupPage() {
		return "/auth/signup";
	}

	@GetMapping("/my/{username}/follower")
	public String follower(Model model, @PathVariable String username) {
		model.addAttribute("username", username);
		return "/follow/follower";
	}

	@GetMapping("/my/{username}/following")
	public String following(@PathVariable String username, Model model) {
		model.addAttribute("username", username);
		return "/follow/following";
	}

	@GetMapping("/my/{username}")
	public String profileForm(Model model, @PathVariable String username,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		ProfileRespDto profileRespDto = null;
		System.out.println(username);
		if (principalDetails != null && principalDetails.getUser().getUsername().equals(username)) {
			profileRespDto = new ProfileRespDto();
			profileRespDto.setUsername(principalDetails.getUser().getUsername());
			profileRespDto.setProfile_img(principalDetails.getUserDtl().getProfile_img());

			model.addAttribute("profileRespDto", profileRespDto);
			return "/feed/my-feed";

		} else {
			profileRespDto = profileService.getProfile(principalDetails, username);
			model.addAttribute("profileRespDto", profileRespDto);
			return "/feed/other_feed";

		}
	}
	
	@GetMapping("/upload")
	public String update() {
		return "/upload/upload";
	}
	@GetMapping("/myInfo")
	public Object insertUserFrom(@AuthenticationPrincipal PrincipalDetails principalDetails , ProfileRespDto profileRespDto) {
	    return "/myInfo/myInfo";
	}
	
	
}
