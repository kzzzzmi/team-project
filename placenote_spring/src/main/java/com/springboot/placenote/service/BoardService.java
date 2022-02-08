package com.springboot.placenote.service;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.web.dto.board.BoardReqDto;
import com.springboot.placenote.web.dto.board.BoardRespDto;

public interface BoardService {

	public boolean insertBoard(BoardReqDto boardReqDto, PrincipalDetails principalDetails);
	public BoardRespDto getBoard(String subCategory, int page, PrincipalDetails principalDetails);
	public int heart(int board_id, int user_id);
	public int heartCancel(int board_id, int user_id);
}
