package com.springboot.placenote.web.dto.board;

import java.util.List;

import com.springboot.placenote.domain.board.IndexBoard;

import lombok.Data;

@Data
public class BoardRespDto {
	private List<IndexBoard> boardList;
}
