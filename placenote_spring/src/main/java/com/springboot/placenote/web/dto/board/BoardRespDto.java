package com.springboot.placenote.web.dto.board;

import java.util.List;

import lombok.Data;

@Data
public class BoardRespDto {
	private List<BoardFileDto> boardList;
}
