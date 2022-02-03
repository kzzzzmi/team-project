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
		System.out.println(boardReqDto.getLocation());
		return boardService.insertBoard(boardReqDto, principalDetails);
	}

	@GetMapping("/getBoardAll")
	public Object getBoardAll(@RequestParam int page) {
		return boardService.getBoardAll(page).getBoardList();
	}
	
	@GetMapping("/getBoard/{subCategory}")
	public Object getBoard(@PathVariable String subCategory, @RequestParam int page) {
		return boardService.getBoardAll(page).getBoardList();
	}

}