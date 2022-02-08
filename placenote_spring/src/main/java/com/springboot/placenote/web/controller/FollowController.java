package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.service.AuthService;
import com.springboot.placenote.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FollowController {

	private final ProfileService profileService;
	private final AuthService authService;

	@PostMapping("/follow/{userId}")
	public int follow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int userId) {
		if(principalDetails != null && (principalDetails.getUser().getId() != userId)) {
			return profileService.follow(principalDetails.getUser().getId(), userId);
		}
		return -1;		
	}

	@DeleteMapping("/follow/{userId}")
	public int followCancel(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int userId) {
		if(principalDetails != null && (principalDetails.getUser().getId() != userId)) {
			return profileService.followCancel(principalDetails.getUser().getId(), userId);
		}
		return -1;
	}

	@GetMapping("/following/list")
	public Object getFollowingList(@AuthenticationPrincipal PrincipalDetails principalDetails, String username) {
		int id = authService.getUserId(username);
		return profileService.getFollowing(principalDetails, id);
	}

	@GetMapping("/follower/list")
	public Object getFollowerList(@AuthenticationPrincipal PrincipalDetails principalDetails, String username) {
		int id = authService.getUserId(username);
		return profileService.getFollower(principalDetails, id);
	}
	
	@GetMapping("/follow/count")
	public Object getFollowCount(String username) {
		return profileService.getFollowCount(username);
	}

}
