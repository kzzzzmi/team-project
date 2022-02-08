package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HeartController {

	private final BoardService boardService;
	
	@PostMapping("/heart/{boardId}")
	public int heart(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int boardId) {
		if(principalDetails != null) {
			return boardService.heart(boardId, principalDetails.getUser().getId());
		}
		return -1;
	}
	
	@DeleteMapping("/heart/{boardId}")
	public int heartCancel(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int boardId) {
		if(principalDetails != null) {
			return boardService.heartCancel(boardId, principalDetails.getUser().getId());
		}
		return -1;
	}
	
}
