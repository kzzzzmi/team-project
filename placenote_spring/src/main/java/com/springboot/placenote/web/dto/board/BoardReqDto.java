package com.springboot.placenote.web.dto.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.placenote.domain.board.Board;

import lombok.Data;

@Data
public class BoardReqDto {
	private List<MultipartFile> files;
	private String location;
	private String keyword;
	private String placeName;
	private String boardContent;
	
	public Board toBoardEntity(int userId, List<String> boardImg) {
		return Board.builder()
				.writer(userId)
				.keyword(keyword)
				.place_name(placeName)
				.board_content(boardContent)
				.file_name(boardImg)
				.location(location)
				.build();
	}
}
