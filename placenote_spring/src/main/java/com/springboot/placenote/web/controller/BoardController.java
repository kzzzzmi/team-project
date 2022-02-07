package com.springboot.placenote.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return boardService.insertBoard(boardReqDto, principalDetails);
	}

	@GetMapping("/getBoard/{subCategory}")
	public Object getBoard(@PathVariable String subCategory, @RequestParam int page, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		return boardService.getBoard(subCategory, page, principalDetails).getBoardList();
	}

}