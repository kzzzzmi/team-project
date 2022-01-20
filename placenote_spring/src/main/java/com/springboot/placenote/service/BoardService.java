package com.springboot.placenote.service;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.web.dto.board.BoardReqDto;

public interface BoardService {

	public boolean insertBoard(BoardReqDto boardReqDto, PrincipalDetails principalDetails);
	
}
