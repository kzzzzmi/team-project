package com.springboot.placenote.web.dto.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.placenote.domain.board.Board;

import lombok.Data;

@Data
public class BoardReqDto {
	private List<MultipartFile> files;
	private String placeName;
	private String boardContent;
	
	public Board toBoardEntity(int userId, String boardImg) {
		return Board.builder()
				.writer(userId)
				.place_name(placeName)
				.board_content(boardContent)
				.
	}
}
