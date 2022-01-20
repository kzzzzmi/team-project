package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.service.BoardService;
import com.springboot.placenote.web.dto.board.BoardReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController {

	private final BoardService boardService;
	
	@PostMapping("/upload")
	public boolean insertBoard(BoardReqDto boardReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println(boardReqDto);
		return boardService.insertBoard(boardReqDto, principalDetails);
	}
	
}
