package com.springboot.placenote.domain.board;

import java.time.LocalDateTime;

import com.springboot.placenote.web.dto.board.BoardFileDto;

import lombok.Data;

@Data
public class IndexBoard {
	private int board_id;
	
	private String profile_img;
	private String writer;
	private String board_content;
	
	private LocalDateTime update_date;
	private String update;
	
	public BoardFileDto toBoardFileDto() {
		return BoardFileDto.builder()
				.board_id(board_id)
				.profile_img(profile_img)
				.writer(writer)
				.board_content(board_content)
				.update_date(update_date)
				.update(update)
				.build();
	}
}
